package com.ly.imp4m.user.service.impl;

import com.ly.imp4m.common.model.SysPermission;
import com.ly.imp4m.common.model.SysRolePermissionRelation;
import com.ly.imp4m.common.model.SysUser;
import com.ly.imp4m.common.model.SysUserRoleRelation;
import com.ly.imp4m.user.service.SysPermissionService;
import com.ly.imp4m.user.service.SysRolePermissionRelationService;
import com.ly.imp4m.user.service.SysUserRoleRelationService;
import com.ly.imp4m.user.service.SysUserService;
import com.ly.imp4m.user.web.vo.SecurityUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 自定义用户认证服务
 * @author sunkl
 * @date 2018/12/23
 */
@Component
@Slf4j
public class SunklMyUserDetailsService implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysUserRoleRelationService sysUserRoleRelationService;

    @Autowired
    private SysRolePermissionRelationService sysRolePermissionRelationService;

    @Autowired
    private SysPermissionService sysPermissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("用户的用户名: {}", username);
        //根据用户名，查找到对应的密码，与权限
        SysUser sysUser = new SysUser();
        sysUser.setAccount(username);
        sysUser = sysUserService.select(sysUser);
        if (sysUser == null) {
            throw new UsernameNotFoundException("用户【"+username+"】不存在");
        }

        //该用户拥有的所有角色
        List<SysUserRoleRelation> sysUserRoleRelations = sysUserRoleRelationService.selectSysUserRelationRoleInfo(sysUser.getId());
        List<String> roleIds = sysUserRoleRelations.stream().map(SysUserRoleRelation::getRoleId).collect(Collectors.toList());

        //查询用户拥有的所有权限
        List<SysRolePermissionRelation> sysRolePermissionRelations = sysRolePermissionRelationService.selectSysPermissionRelationRoleInfo(roleIds);
        List<String> permissionIds = sysRolePermissionRelations.stream().map(SysRolePermissionRelation::getPermissionId).collect(Collectors.toList());
        List<SysPermission> sysPermissions = sysPermissionService.selectSysPermission(permissionIds);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (SysPermission permission:sysPermissions) {
            if (permission != null && permission.getName()!=null) {

                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getId());
                //1：此处将权限信息添加到 GrantedAuthority 对象中，在后面进行全权限验证时会使用GrantedAuthority 对象。
                grantedAuthorities.add(grantedAuthority);
            }
        }

        //封装用户信息，并返回。参数分别是：用户名，密码，用户权限
        return new SecurityUser(
                sysUser.getId(),
                sysUser.getName(),
                sysUser.getOrgId(),
                sysUser.getPassword(),
                sysUser.getAccount(),
                grantedAuthorities
        );
  }
}

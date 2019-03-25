package com.ly.imp4m.home.web;

import com.ly.imp4m.common.enums.PermissionTypeEnums;
import com.ly.imp4m.common.util.EnvUtils;
import com.ly.imp4m.common.model.SysPermission;
import com.ly.imp4m.common.model.SysRolePermissionRelation;
import com.ly.imp4m.common.model.SysUserRoleRelation;
import com.ly.imp4m.home.web.vo.SysPermissionMenuTreeVo;
import com.ly.imp4m.user.service.SysPermissionService;
import com.ly.imp4m.user.service.SysRolePermissionRelationService;
import com.ly.imp4m.user.service.SysUserRoleRelationService;
import com.ly.imp4m.user.web.vo.SecurityUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 主页
 *
 * @author sunkl
 * @version 2018/12/7
 */
@Controller
@Api(tags = "首页管理")
@RequestMapping
public class HomeController {

    @Autowired
    private SysPermissionService sysPermissionService;

    @Autowired
    private SysUserRoleRelationService sysUserRoleRelationService;

    @Autowired
    private SysRolePermissionRelationService sysRolePermissionRelationService;

    @ApiOperation(value = "首页")
    @GetMapping("/")
    @ApiIgnore
    public String index(Model model) {

        //查询菜单列表
        String currentUserId = EnvUtils.getCurrentUserId();

        //该用户拥有的所有角色
        List<SysUserRoleRelation> sysUserRoleRelations = sysUserRoleRelationService.selectSysUserRelationRoleInfo(currentUserId);
        List<String> roleIds = sysUserRoleRelations.stream().map(SysUserRoleRelation::getRoleId).collect(Collectors.toList());

        //查询用户拥有的所有权限
        List<SysRolePermissionRelation> sysRolePermissionRelations = sysRolePermissionRelationService.selectSysPermissionRelationRoleInfo(roleIds);
        List<String> permissionIds = sysRolePermissionRelations.stream().map(SysRolePermissionRelation::getPermissionId).collect(Collectors.toList());
        List<SysPermission> menus = sysPermissionService.selectSysPermission(permissionIds);
        Map<String, SysPermissionMenuTreeVo> sysPermissionMenuTreeVoMap = menus.stream()
                .filter(sysPermission -> {
                    if (PermissionTypeEnums.MENU.getStringValue().equals(sysPermission.getType())) {
                        return true;
                    }
                    return false;
                })
                .map(sysPermission -> {
                    SysPermissionMenuTreeVo sysPermissionMenuTreeVo = new SysPermissionMenuTreeVo();
                    sysPermissionMenuTreeVo.setId(sysPermission.getId());
                    sysPermissionMenuTreeVo.setName(sysPermission.getName());
                    sysPermissionMenuTreeVo.setUrl(sysPermission.getUrl());
                    sysPermissionMenuTreeVo.setPid(sysPermission.getPid());
                    sysPermissionMenuTreeVo.setChild(new ArrayList<>());
                    return sysPermissionMenuTreeVo;
                }).collect(Collectors.toMap(SysPermissionMenuTreeVo::getId, a -> a));
        for (Map.Entry<String, SysPermissionMenuTreeVo> entry : sysPermissionMenuTreeVoMap.entrySet()) {
            SysPermissionMenuTreeVo value = entry.getValue();
            if (!"0".equals(value.getPid())) {
                sysPermissionMenuTreeVoMap.get(value.getPid()).getChild().add(value);
            }
        }
        List<SysPermissionMenuTreeVo> collect = sysPermissionMenuTreeVoMap.values().stream().filter(sysPermissionMenuTreeVo -> {
            if (!"0".equals(sysPermissionMenuTreeVo.getPid())) {
                return false;
            } else {
                return true;
            }
        }).collect(Collectors.toList());
        model.addAttribute("user_name", EnvUtils.getCurrentUserName());
        model.addAttribute("menus", collect);
        return "home/index";
    }

    @ApiOperation(value = "查询当前登录用于信息")
    @GetMapping("/get-current-user-info")
    @ResponseBody
    public SecurityUser getSysRoleInfo() {
        return EnvUtils.getCurrentUser();
    }
}

package com.ly.vrps.management.home.web;

import com.ly.vrps.common.enums.PermissionTypeEnums;
import com.ly.vrps.common.model.SysPermission;
import com.ly.vrps.common.model.SysRole;
import com.ly.vrps.management.home.web.vo.SysPermissionMenuTreeVo;
import com.ly.vrps.management.user.service.SysPermissionService;
import com.ly.vrps.management.user.service.SysRolePermissionRelationService;
import com.ly.vrps.management.user.service.SysRoleService;
import com.ly.vrps.management.user.web.vo.SysPermissionVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    private SysRolePermissionRelationService sysRolePermissionRelationService;

    @Autowired
    private SysRoleService sysRoleService;

    @ApiOperation(value = "首页")
    @GetMapping("/")
    @ApiIgnore
    public String index(Model model) {

        //查询菜单列表

        //该用户拥有的所有角色
        List<SysRole> sysRoles = sysRoleService.selectSysRoleInfo(new SysRole());
        List<String> roleIds = sysRoles.stream().map(SysRole::getId).collect(Collectors.toList());

        //查询用户拥有的所有权限
        //List<SysRolePermissionRelation> sysRolePermissionRelations = sysRolePermissionRelationService.selectSysPermissionRelationRoleInfo(roleIds);
        List<SysPermissionVo> sysPermissionVos = sysPermissionService.selectSysPermissionInfo(new SysPermission());
        List<String> permissionIds = sysPermissionVos.stream().map(SysPermissionVo::getId).collect(Collectors.toList());
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
        model.addAttribute("menus", collect);
        return "home/index";
    }

}

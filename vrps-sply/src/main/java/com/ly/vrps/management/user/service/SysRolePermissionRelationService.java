package com.ly.vrps.management.user.service;

import com.ly.vrps.common.model.SysRolePermissionRelation;
import com.ly.vrps.management.user.web.vo.SysRolePermissionRelationQueryVo;

import java.util.List;

/**
 * 角色权限关联服务
 * @author sunkl
 * @date 2018/12/21
 */
public interface SysRolePermissionRelationService {

    /**
     * 
     * 查询角色权限信息
     * @author sunkl
     * @date 2018/12/21
     * @param roleId
     * @return
     */
    List<SysRolePermissionRelation> selectSysPermissionRelationRoleInfo(String roleId);

    /**
     * 查询角色权限信息
     * @author sunkl
     * @date 2018/12/23
     * @param roleIds
     * @return
     */
    List<SysRolePermissionRelation> selectSysPermissionRelationRoleInfo(List<String> roleIds);

    /**
     * 增加关联信息
     * @author sunkl
     * @date 2018/12/22
     * @param sysRolePermissionRelationQueryVo
     */
    void addRolePerMissionRelation(SysRolePermissionRelationQueryVo sysRolePermissionRelationQueryVo);

}

package com.ly.imp4m.common.dao;

import com.ly.imp4m.common.model.SysRolePermissionRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author sunkl
 * @date 2018年12月21日 14:25:53
 */
public interface SysRolePermissionRelationMapper extends BaseDao<SysRolePermissionRelation> {

    /**
     * 查询角色权限信息
     * @author sunkl
     * @date 2018/12/23
     * @param roleIds
     * @return
     */
    List<SysRolePermissionRelation> selectByRoleIds(@Param("roleIds") List<String> roleIds);
}
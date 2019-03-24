package com.ly.imp4m.common.dao;

import com.ly.imp4m.common.model.SysPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author sunkl
 * @date 2018年12月21日 15:11:59
 */
public interface SysPermissionMapper extends BaseDao<SysPermission> {

    /**
     * 根据permissionIds查询权限信息
     * @author sunkl
     * @date 2018/12/23
     * @param permissionIds
     * @return
     */
    List<SysPermission> selectByIds(@Param("permissionIds") List<String> permissionIds);
}
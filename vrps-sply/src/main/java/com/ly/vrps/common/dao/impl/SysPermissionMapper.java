package com.ly.vrps.common.dao.impl;

import com.ly.vrps.common.dao.BaseDao;
import com.ly.vrps.common.model.SysPermission;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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

    /**
     * 根据用户id获取权限(资源)
     * @author sunkl
     * @date 2019/4/14 1:33
     * @param userId
     * @return
     */
    @Select(value = "select *\n" +
            "from t_sys_permission sp\n" +
            "left join t_sys_role_permission_relation srpr on srpr.permission_id = sp.id\n" +
            "left join t_sys_user_role_relation surr on srpr.role_id = surr.role_id\n" +
            "where surr.user_id = #{userId};")
    List<SysPermission> getByUserId(@Param(value = "userId") String userId);
}
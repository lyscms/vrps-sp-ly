package com.ly.vrps.management.user.service;

import com.github.pagehelper.PageInfo;
import com.ly.vrps.common.model.SysPermission;
import com.ly.vrps.management.user.web.vo.SysPermissionInfoQueryVo;
import com.ly.vrps.management.user.web.vo.SysPermissionVo;

import java.util.List;

/**
 * 权限服务层接口
 * @author sunkl
 * @date 2018/12/21
 */
public interface SysPermissionService {

    /**
     * 获取指定id的权限信息
     * @author sunkl
     * @date 2018/12/21
     * @param id
     * @return
     */
    SysPermission getSysPermissionInfo(String id);

    /**
     * 条件查询权限信息
     * @author sunkl
     * @date 2018/12/21
     * @param sysPermission
     * @return
     */
    List<SysPermissionVo> selectSysPermissionInfo(SysPermission sysPermission);

    /**
     * 更新权限信息
     * @author sunkl
     * @date 2018/12/21
     * @param sysPermissionInfoQueryVo
     */
    void update(SysPermissionInfoQueryVo sysPermissionInfoQueryVo);

    /**
     * 添加权限信息
     * @author sunkl
     * @date 2018/12/21
     * @param sysPermissionInfoQueryVo
     */
    void insert(SysPermissionInfoQueryVo sysPermissionInfoQueryVo);

    /**
     * 删除权限信息
     * @author sunkl
     * @date 2018/12/21
     * @param id
     */
    void deleteByPrimaryKey(String id);

    /**
     * 查询菜单信息
     * @author sunkl
     * @date 2018/12/23
     * @return
     */
    List<SysPermission> getMenus();

    /**
     * 根据permissionIds查询权限信息
     * @author sunkl
     * @date 2018/12/23
     * @param permissionIds
     * @return
     */
    List<SysPermission> selectSysPermission(List<String> permissionIds);

    /**
     * 根据swagger扫描更新权限列表
     * @author sunkl
     * @date 2018/12/29
     * @return
     */
    Boolean updatePermissionBySwagger();

    /**
     * 分页查询角色信息
     * @param sysPermission
     * @param page
     * @param limit
     * @return
     */
    PageInfo<SysPermission> selectSysPermissions(SysPermission sysPermission, int page, int limit);

    /**
     * 根据用户id获取对应的权限(资源)
     * @author sunkl
     * @date 2019/4/14 1:32
     * @param userId
     * @return
     */
    List<SysPermission> getByUserId(String userId);
}

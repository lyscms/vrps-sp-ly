package com.ly.imp4m.management.user.service;

import com.ly.imp4m.common.model.SysRole;
import com.ly.imp4m.common.service.BaseService;

import java.util.List;

/**
 * 角色service层接口
 * @author sunkl
 * @date 2018/12/6
 */
public interface SysRoleService extends BaseService<SysRole> {

    /**
     * 获取用户角色信息
     * @author sunkl
     * @date 2018/12/6
     * @param id
     * @return
     */
    SysRole getSysRoleInfo(String id);

    /**
     * 获取所有角色信息
     * @author sunkl
     * @date 2018/12/7
     * @param sysRole
     * @return
     */
    List<SysRole> selectSysRoleInfo(SysRole sysRole);

    /**
     * 修改角色信息
     * @author sunkl
     * @date 2018/12/11
     * @param sysRole
     */
    void update(SysRole sysRole);
}

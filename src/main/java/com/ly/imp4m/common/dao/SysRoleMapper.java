package com.ly.imp4m.common.dao;

import com.ly.imp4m.common.model.SysRole;

import java.util.List;

/**
 * 用户角色表
 * @author sunkl
 * @date 2018年12月07日 10:47:45
 */
public interface SysRoleMapper extends BaseDao<SysRole> {

    /**
     * 查询所有角色信息
     * @author sunkl
     * @date 2018/12/7
     * @param sysRole
     * @return
     */
    List<SysRole> select(SysRole sysRole);

    /**
     * 修改指定角色信息
     * @author sunkl
     * @date 2018/12/11
     * @param sysRole
     */
    void update(SysRole sysRole);
}
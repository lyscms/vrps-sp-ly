package com.ly.imp4m.common.dao;

import com.ly.imp4m.common.model.SysUser;

import java.util.List;

/**
 * @author sunkl
 * @date 2018年12月11日 18:44:44
 */
public interface SysUserMapper extends BaseDao<SysUser> {
    /**
     * 查询所有用户信息
     * @author sunkl
     * @date 2018/12/7
     * @param sysUser
     * @return
     */
    List<SysUser> select(SysUser sysUser);

    /**
     * 修改指定用户信息
     * @author sunkl
     * @date 2018/12/11
     * @param sysUser
     */
    void update(SysUser sysUser);

    /**
     * 查询指定用户信息
     * @param sysUser
     * @return
     */
    SysUser selectOne(SysUser sysUser);
}
package com.ly.vrps.common.dao.impl;

import com.ly.vrps.common.dao.BaseDao;
import com.ly.vrps.common.model.SysUserRoleRelation;

/**
 * 用户角色关联表
 * @author sunkl
 * @date 2018年12月20日 09:16:52
 */
public interface SysUserRoleRelationMapper extends BaseDao<SysUserRoleRelation> {

    /**
     * 更新数据
     * @author sunkl
     * @date 2018/12/20
     * @param record
     * @return
     */
    int updateByPrimaryKey(SysUserRoleRelation record);
}
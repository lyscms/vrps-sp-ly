package com.ly.vrps.management.user.service;


import com.ly.vrps.common.model.SysUserRoleRelation;
import com.ly.vrps.management.user.web.vo.SysUserInfoQueryVo;

import java.util.List;

/**
 * 用户角色关联服务层
 * @author sunkl
 * @date 2018/12/20
 */
public interface SysUserRoleRelationService {


    /**
     * 删除角色关联信息
     * @author sunkl
     * @date 2018/12/20
     * @param id
     */
    void deleteByUserId(String id);

    /**
     * 更新用户角色信息关联
     * @author sunkl
     * @date 2018/12/20
     * @param sysUserInfoQueryVo
     */
    void updateUserRoleRelation(SysUserInfoQueryVo sysUserInfoQueryVo);

    /**
     * 查询用户关联的角色信息
     * @author sunkl
     * @date 2018/12/20
     * @param userId
     * @return
     */
    List<SysUserRoleRelation> selectSysUserRelationRoleInfo(String userId);

}

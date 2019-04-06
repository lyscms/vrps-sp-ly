package com.ly.vrps.management.user.service.impl;

import com.ly.vrps.common.dao.impl.SysUserRoleRelationMapper;
import com.ly.vrps.common.model.SysUserRoleRelation;
import com.ly.vrps.common.service.impl.BaseServiceImpl;
import com.ly.vrps.management.user.service.SysUserRoleRelationService;
import com.ly.vrps.management.user.web.vo.SysUserInfoQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户角色关联信息service层实现
 * @author sunkl
 * @date 2018/12/6
 */
@Service
public class SysUserRoleRelationServiceImpl extends BaseServiceImpl<SysUserRoleRelation> implements SysUserRoleRelationService {

    @Autowired
    private SysUserRoleRelationMapper sysUserRoleRelationMapper;

    @Override
    public void deleteByUserId(String userId) {
        SysUserRoleRelation sysUserRoleRelation = new SysUserRoleRelation();
        sysUserRoleRelation.setUserId(userId);
        sysUserRoleRelationMapper.delete(sysUserRoleRelation);
    }

    @Override
    public void updateUserRoleRelation(SysUserInfoQueryVo sysUserInfoQueryVo) {

        //删除之前的关联信息
        deleteByUserId(sysUserInfoQueryVo.getId());

        //添加新的角色关联信息
        String role = sysUserInfoQueryVo.getRole();
        String[] split = role.split("\\,");
        for (int i = 0; i < split.length; i++) {
            SysUserRoleRelation sysUserRoleRelation = new SysUserRoleRelation();
            sysUserRoleRelation.beforeInsert();
            sysUserRoleRelation.setUserId(sysUserInfoQueryVo.getId());
            sysUserRoleRelation.setRoleId(split[i]);
            sysUserRoleRelationMapper.insert(sysUserRoleRelation);
        }
    }

    @Override
    public List<SysUserRoleRelation> selectSysUserRelationRoleInfo(String userId) {
        SysUserRoleRelation sysUserRoleRelation = new SysUserRoleRelation();
        sysUserRoleRelation.setUserId(userId);
        return sysUserRoleRelationMapper.select(sysUserRoleRelation);
    }
}

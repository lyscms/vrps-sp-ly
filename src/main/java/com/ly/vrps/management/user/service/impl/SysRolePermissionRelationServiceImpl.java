package com.ly.vrps.management.user.service.impl;

import com.ly.vrps.common.dao.impl.SysRolePermissionRelationMapper;
import com.ly.vrps.common.model.SysRolePermissionRelation;
import com.ly.vrps.management.user.service.SysRolePermissionRelationService;
import com.ly.vrps.management.user.web.vo.SysRolePermissionRelationQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色权限关联服务实现
 * @author sunkl
 * @date 2018/12/21
 */
@Service
public class SysRolePermissionRelationServiceImpl implements SysRolePermissionRelationService {

    @Autowired
    private SysRolePermissionRelationMapper sysRolePermissionRelationMapper;

    @Override
    public List<SysRolePermissionRelation> selectSysPermissionRelationRoleInfo(String roleId) {
        SysRolePermissionRelation sysRolePermissionRelation = new SysRolePermissionRelation();
        sysRolePermissionRelation.setRoleId(roleId);
        return sysRolePermissionRelationMapper.select(sysRolePermissionRelation);
    }

    @Override
    public List<SysRolePermissionRelation> selectSysPermissionRelationRoleInfo(List<String> roleIds) {
        return sysRolePermissionRelationMapper.selectByRoleIds(roleIds);
    }

    @Override
    public void addRolePerMissionRelation(SysRolePermissionRelationQueryVo sysRolePermissionRelationQueryVo) {
        SysRolePermissionRelation sysRolePermissionRelationCondition = new SysRolePermissionRelation();
        sysRolePermissionRelationCondition.setRoleId(sysRolePermissionRelationQueryVo.getRoleId());
        sysRolePermissionRelationMapper.delete(sysRolePermissionRelationCondition);

        List<String> permissionIds = sysRolePermissionRelationQueryVo.getPermissionIds();
        for (int i = 0; i < permissionIds.size(); i++) {
            SysRolePermissionRelation sysRolePermissionRelation = new SysRolePermissionRelation();
            sysRolePermissionRelation.setRoleId(sysRolePermissionRelationQueryVo.getRoleId());
            sysRolePermissionRelation.setPermissionId(permissionIds.get(i));
            sysRolePermissionRelation.beforeInsert();
            sysRolePermissionRelationMapper.insert(sysRolePermissionRelation);
        }
    }
}

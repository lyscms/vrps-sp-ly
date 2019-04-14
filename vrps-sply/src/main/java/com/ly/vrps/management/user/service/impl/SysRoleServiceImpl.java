package com.ly.vrps.management.user.service.impl;

import com.ly.vrps.common.dao.impl.SysRoleMapper;
import com.ly.vrps.common.model.SysRole;
import com.ly.vrps.common.service.impl.BaseServiceImpl;
import com.ly.vrps.management.user.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色service层接口
 * @author sunkl
 * @date 2018/12/6
 */
@Service
public class SysRoleServiceImpl extends BaseServiceImpl<SysRole> implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public SysRole getSysRoleInfo(String id) {
        return sysRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SysRole> selectSysRoleInfo(SysRole sysRole) {
        return sysRoleMapper.select(sysRole);
    }

    @Override
    public void update(SysRole sysRole) {
        sysRoleMapper.updateByPrimaryKeySelective(sysRole);
    }
}

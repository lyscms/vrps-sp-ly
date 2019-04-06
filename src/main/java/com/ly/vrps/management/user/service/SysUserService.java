package com.ly.vrps.management.user.service;

import com.github.pagehelper.PageInfo;
import com.ly.vrps.common.model.SysUser;
import com.ly.vrps.common.service.BaseService;
import com.ly.vrps.management.user.web.vo.SysUserVo;


/**
 * service层接口
 * @author sunkl
 * @date 2018/12/6
 */
public interface SysUserService extends BaseService<SysUser> {

    /**
     * 获取用户信息
     * @author sunkl
     * @date 2018/12/6
     * @param id
     * @return
     */
    SysUser getSysUserInfo(String id);

    /**
     * 获取所有信息
     * @author sunkl
     * @date 2018/12/7
     * @param sysUser
     * @param page
     * @param limit
     * @return
     */
    PageInfo<SysUserVo> selectSysUserInfo(SysUser sysUser, int page, int limit);

    /**
     * 修改信息
     * @author sunkl
     * @date 2018/12/11
     * @param sysUser
     */
    void update(SysUser sysUser);

    /**
     * 查询用户信息
     * @author sunkl
     * @date 2018/12/23
     * @param sysUser
     * @return
     */
    SysUser select(SysUser sysUser);
}

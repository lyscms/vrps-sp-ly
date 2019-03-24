package com.ly.imp4m.common.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 数据展示层
 * @author sunkl
 * @date 2018年12月11日 18:44:44
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SysUser extends BaseModel {
    /**
     * 用户名称
     */
    private String name;

    /**
     * 所属组织id
     */
    private String orgId;

    /**
     * 账户
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 状态, 0：离线 1：在线
     */
    private Integer status;

    /**
     * 是否启用，0：禁用 1：启用
     */
    private Integer enable;

    /**
     * 最后登录时间
     */
    private Date lastLoginTime;

    /**
     * 最后登录ip地址
     */
    private String lastLoginIpAddress;

    /**
     * 登录次数
     */
    private Integer loginCount;

}
package com.ly.vrps.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Table;

/**
 * 用户角色关联表
 * @author sunkl
 * @date 2018年12月20日 09:16:52
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "t_sys_user_role_relation")
public class SysUserRoleRelation extends BaseModel {
    /**
     * 用户角色
     */
    private String userId;

    /**
     * 角色id
     */
    private String roleId;
}
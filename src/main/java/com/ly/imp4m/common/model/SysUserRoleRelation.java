package com.ly.imp4m.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 用户角色关联表
 * @author sunkl
 * @date 2018年12月20日 09:16:52
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
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
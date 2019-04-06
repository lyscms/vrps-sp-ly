package com.ly.vrps.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Table;

/**
 * @author sunkl
 * @date 2018年12月21日 14:25:53
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "t_sys_role_permission_relation")
public class SysRolePermissionRelation extends BaseModel {
    /**
     * 角色id
     */
    private String roleId;

    /**
     * 权限id
     */
    private String permissionId;
}
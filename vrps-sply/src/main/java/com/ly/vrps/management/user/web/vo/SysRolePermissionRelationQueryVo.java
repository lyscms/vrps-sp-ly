package com.ly.vrps.management.user.web.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.List;

/**
 * 角色权限关联Vo
 * @author sunkl
 * @date 2018/12/22
 */
@Data
@ApiModel(value = "角色权限关联Vo")
public class SysRolePermissionRelationQueryVo {

    /**
     * 角色Id
     */
    @ApiModelProperty(value = "角色Id")
    private String roleId;

    /**
     * 权限数组
     */
    @ApiModelProperty(value = "权限数组")
    private List<String> permissionIds;
}

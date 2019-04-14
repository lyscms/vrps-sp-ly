package com.ly.vrps.management.user.web.vo;

import com.ly.vrps.common.model.SysUser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户信息列表Vo
 * @author sunkl
 * @date 2018/12/7
 */
@Data
@ApiModel(value = "用户信息请求参数")
@EqualsAndHashCode(callSuper = false)
public class SysUserInfoQueryVo extends SysUser {

    @ApiModelProperty(value = "选中的角色id")
    private String role;
}

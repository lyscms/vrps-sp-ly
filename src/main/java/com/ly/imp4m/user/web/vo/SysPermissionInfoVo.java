package com.ly.imp4m.user.web.vo;

import com.ly.imp4m.common.model.SysPermission;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


/**
 * 权限信息列表
 * @author sunkl
 * @date 2018/12/21
 */
@Data
@ApiModel(value = "权限信息列表")
public class SysPermissionInfoVo {

    @ApiModelProperty(value = "返回状态码",name = "code")
    private String code;

    @ApiModelProperty(value = "总共记录数",name = "count")
    private Integer count;

    @ApiModelProperty(value = "用户信息列表",name = "data")
    private List<SysPermission> data;
}

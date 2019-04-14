package com.ly.vrps.management.user.web.vo;

import com.ly.vrps.common.model.SysRole;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.List;

/**
 * 角色信息列表Vo
 * @author sunkl
 * @date 2018/12/7
 */
@Data
@ApiModel(value = "角色信息列表")
public class SysRoleInfoVo {

    @ApiModelProperty(value = "返回状态码",name = "code")
    private String code;

    @ApiModelProperty(value = "总共记录数",name = "count")
    private Integer count;

    @ApiModelProperty(value = "角色信息列表",name = "data")
    private List<SysRole> data;
}

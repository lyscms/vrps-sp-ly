package com.ly.vrps.management.busmanager.vo;


import com.ly.vrps.common.model.VipCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Vip Code
 * @author sunkl
 * @date 2019/4/14 22:08
 */
@Data
@ApiModel(value = "VipCode信息列表")
public class VipCodeVo {

    @ApiModelProperty(value = "返回状态码",name = "code")
    private String code;

    @ApiModelProperty(value = "总共记录数",name = "count")
    private Integer count;

    @ApiModelProperty(value = "Vip信息列表",name = "data")
    private List<VipCode> data;
}

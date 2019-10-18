package com.ly.vrps.management.busmanager.vo;

import com.ly.vrps.common.model.Location;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


/**
 * 地区信息列表Vo
 * @author 1058980664
 * @date 2018/12/7
 */
@Data
@ApiModel(value = "地区信息列表")
public class LocInfoVo {

    @ApiModelProperty(value = "返回状态码",name = "code")
    private String code;

    @ApiModelProperty(value = "总共记录数",name = "count")
    private Integer count;

    @ApiModelProperty(value = "地区信息列表",name = "data")
    private List<Location> data;
}

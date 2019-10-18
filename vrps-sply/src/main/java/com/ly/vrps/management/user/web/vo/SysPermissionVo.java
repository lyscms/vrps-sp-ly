package com.ly.vrps.management.user.web.vo;


import com.ly.vrps.common.model.SysPermission;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 权限信息Vo
 * @author 1058980664
 * @date 2018/12/21
 */
@Data
@ApiModel(value = "权限信息")
@EqualsAndHashCode(callSuper = true)
public class SysPermissionVo extends SysPermission {
}

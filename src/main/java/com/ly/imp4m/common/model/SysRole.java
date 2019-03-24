package com.ly.imp4m.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 用户角色表
 * @author sunkl
 * @date 2018年12月07日 10:47:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SysRole extends BaseModel {
    /**
     * 角色别名
     */
    private String alias;

    /**
     * 角色名
     */
    private String name;
}
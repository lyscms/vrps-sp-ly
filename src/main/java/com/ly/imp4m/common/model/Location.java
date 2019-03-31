package com.ly.imp4m.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 地区
 * @author sunkl
 * @date 2019年03月31日 10:45:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Location extends BaseModel {
    /**
     * 是否在使用
     */
    private Integer isUse;

    /**
     * 名称
     */
    private String name;
}
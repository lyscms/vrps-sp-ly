package com.ly.imp4m.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 年份
 * @author sunkl
 * @date 2019年03月31日 10:45:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Decade extends BaseModel {
    /**
     * 是否在使用
     */
    private Integer isUse;

    /**
     * 名称
     */
    private String name;

    /**
     * 排序
     */
    private Integer sort;
}
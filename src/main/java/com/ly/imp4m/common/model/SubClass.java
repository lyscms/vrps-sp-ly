package com.ly.imp4m.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 子分类
 * @author sunkl
 * @date 2019年03月31日 10:45:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SubClass extends BaseModel {
    /**
     * 是否使用
     */
    private Integer isUse;

    /**
     * 名称
     */
    private String name;

    /**
     * 目录id
     */
    private String catalogId;
}
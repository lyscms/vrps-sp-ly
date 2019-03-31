package com.ly.imp4m.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 目录
 * @author sunkl
 * @date 2019年03月31日 10:45:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CataLog extends BaseModel {
    /**
     * 是否在使用
     */
    private Integer isUse;

    /**
     * 目录名称
     */
    private String name;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 是否vip
     */
    private Integer isVip;
}
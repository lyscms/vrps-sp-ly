package com.ly.vrps.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Table;

/**
 * 类型
 * @author sunkl
 * @date 2019年03月31日 10:45:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "t_bus_type")
public class Type extends BaseModel {
    /**
     * 是否在使用
     */
    private Integer isUse;

    /**
     * 类型名称
     */
    private String name;

    /**
     * 子分类id
     */
    private String subclassId;
}
package com.ly.vrps.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.util.List;

/**
 * 目录
 * @author sunkl
 * @date 2019年03月31日 10:45:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "t_bus_catalog")
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

    /**
     * 二级目录
     */
    private List<SubClass> subClassList;
}
package com.ly.vrps.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Table;

/**
 * 影片级别
 * @author 1058980664
 * @date 2019年03月31日 10:45:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "t_bus_level")
public class Level extends BaseModel {
    /**
     * 是否在使用
     */
    private Integer isUse;

    /**
     * 等级名称
     */
    private String name;
}
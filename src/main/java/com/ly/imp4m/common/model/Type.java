package com.ly.imp4m.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author sunkl
 * @date 2019年03月28日 00:18:21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Type extends BaseModel {
    /**
     * 
     */
    private Integer isuse;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String subclassId;
}
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
public class Film extends BaseModel {
    /**
     * 
     */
    private String actor;

    /**
     * 
     */
    private String catalogname;

    /**
     * 
     */
    private String catalogId;

    /**
     * 
     */
    private Double evaluation;

    /**
     * 
     */
    private String image;

    /**
     * 
     */
    private Integer isuse;

    /**
     * 
     */
    private String locname;

    /**
     * 
     */
    private String locId;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String ondecade;

    /**
     * 
     */
    private String resolution;

    /**
     * 
     */
    private String status;

    /**
     * 
     */
    private String subclassname;

    /**
     * 
     */
    private String subclassId;

    /**
     * 
     */
    private String typename;

    /**
     * 
     */
    private String typeId;

    /**
     * 
     */
    private String updatetime;

    /**
     * 
     */
    private Integer isvip;

    /**
     * 
     */
    private String plot;
}
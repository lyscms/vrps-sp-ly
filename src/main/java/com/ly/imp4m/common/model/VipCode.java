package com.ly.imp4m.common.model;

import java.util.Date;
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
public class VipCode extends BaseModel {
    /**
     * 
     */
    private String code;

    /**
     * 
     */
    private String isUse;

    /**
     * 
     */
    private Date expireTime;
}
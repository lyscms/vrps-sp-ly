package com.ly.imp4m.common.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * vip编码
 * @author sunkl
 * @date 2019年03月31日 10:45:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class VipCode extends BaseModel {
    /**
     * 编码
     */
    private String code;

    /**
     * 是否使用
     */
    private Integer isUse;

    /**
     * 过期时间
     */
    private Date expireTime;
}
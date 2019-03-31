package com.ly.imp4m.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 资源
 * @author sunkl
 * @date 2019年03月31日 10:45:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Res extends BaseModel {
    /**
     * 集数
     */
    private Integer episodes;

    /**
     * 是否使用
     */
    private Integer isUse;

    /**
     * 链接类型
     */
    private String linkType;

    /**
     * 影片名称
     */
    private String filmId;
}
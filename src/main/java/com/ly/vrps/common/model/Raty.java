package com.ly.vrps.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Table;

/**
 * 评分
 * @author sunkl
 * @date 2019年03月31日 10:45:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "t_bus_raty")
public class Raty extends BaseModel {
    /**
     * 时间	
     */
    private String enTime;

    /**
     * 影片id
     */
    private String filmId;

    /**
     * 分数
     */
    private String score;
}
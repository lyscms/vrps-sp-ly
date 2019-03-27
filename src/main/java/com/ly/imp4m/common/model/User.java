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
public class User extends BaseModel {
    /**
     * 
     */
    private Integer isvip;

    /**
     * 
     */
    private Date createtime;

    /**
     * 
     */
    private Date expiretime;

    /**
     * 
     */
    private String useremail;

    /**
     * 
     */
    private String username;

    /**
     * 
     */
    private String userpasswd;
}
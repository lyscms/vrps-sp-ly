package com.ly.vrps.common.service;

/**
 * Service层基类
 * @author sunkl
 * @date 2018/12/7
 */
public interface BaseService <T>{
    /**
     * deleteByPrimaryKey
     * @author sunkl
     * @date 2018年12月07日 09:52:43
     * @param id
     * @return int
     */
    int deleteByPrimaryKey(String id);

    /**
     * insert
     * @author sunkl
     * @date 2018年12月07日 09:52:43
     * @param t
     * @return int
     */
    int insert(T t);

    /**
     * insertSelective
     * @author sunkl
     * @date 2018年12月07日 09:52:43
     * @param t
     * @return int
     */
    int insertSelective(T t);

    /**
     * selectByPrimaryKey
     * @author sunkl
     * @date 2018年12月07日 09:52:43
     * @param id
     * @return com.sunkl.my.common.model.SysRole
     */
    T selectByPrimaryKey(String id);
}

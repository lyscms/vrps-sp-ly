package com.ly.vrps.common.service;

/**
 * Service层基类
 * @author 1058980664
 * @date 2018/12/7
 */
public interface BaseService <T>{
    /**
     * deleteByPrimaryKey
     * @author 1058980664
     * @date 2018年12月07日 09:52:43
     * @param id
     * @return int
     */
    int deleteByPrimaryKey(String id);

    /**
     * insert
     * @author 1058980664
     * @date 2018年12月07日 09:52:43
     * @param t
     * @return int
     */
    int insert(T t);

    /**
     * insertSelective
     * @author 1058980664
     * @date 2018年12月07日 09:52:43
     * @param t
     * @return int
     */
    int insertSelective(T t);

    /**
     * selectByPrimaryKey
     * @author 1058980664
     * @date 2018年12月07日 09:52:43
     * @param id
     * @return com.1058980664.my.common.model.SysRole
     */
    T selectByPrimaryKey(String id);
}

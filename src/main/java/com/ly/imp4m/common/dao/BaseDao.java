package com.ly.imp4m.common.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Dao层基类
 * @author sunkl
 * @date 2018/12/7
 */
@Mapper
public interface BaseDao <T>{
    /**
     * deleteByPrimaryKey
     * @author sunkl
     * @date 2018年12月07日 09:52:43
     * @param id
     * @return int
     */
    int deleteByPrimaryKey(String id);


    /**
     * deleteSelective
     * @author sunkl
     * @date 2018年12月07日 09:52:43
     * @param t
     * @return int
     */
    int deleteSelective(T t);

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
     * @return T
     */
    T selectByPrimaryKey(String id);

    /**
     * selectByPrimarySelective
     * @author sunkl
     * @date 2018年12月07日 09:52:43
     * @param t
     * @return T
     */
    List<T> selectSelective(T t);

    /**
     * updateByPrimaryKeySelective
     * @author sunkl
     * @date 2018/12/18
     * @param t
     * @return
     */
    int updateByPrimaryKeySelective(T t);
}

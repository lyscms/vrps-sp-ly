package com.ly.vrps.common.dao;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Dao层基类
 * @author 1058980664
 * @date 2018/12/7
 */
public interface BaseDao <T> extends Mapper<T>, MySqlMapper<T> {

}

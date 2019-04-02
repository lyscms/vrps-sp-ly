package com.ly.imp4m.common.dao;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Dao层基类
 * @author sunkl
 * @date 2018/12/7
 */
public interface BaseDao <T> extends Mapper<T>, MySqlMapper<T> {

}

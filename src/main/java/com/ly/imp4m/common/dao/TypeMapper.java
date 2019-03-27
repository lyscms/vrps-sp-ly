package com.ly.imp4m.common.dao;

import com.ly.imp4m.common.model.Type;

/**
 * @author sunkl
 * @date 2019年03月28日 00:18:21
 */
public interface TypeMapper extends BaseDao<Type> {
    int updateByPrimaryKey(Type record);
}
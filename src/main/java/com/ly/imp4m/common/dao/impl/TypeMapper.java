package com.ly.imp4m.common.dao.impl;

import com.ly.imp4m.common.dao.BaseDao;
import com.ly.imp4m.common.model.Type;

/**
 * 类型
 * @author sunkl
 * @date 2019年03月31日 10:45:31
 */
public interface TypeMapper extends BaseDao<Type> {
    int updateByPrimaryKey(Type record);
}
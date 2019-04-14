package com.ly.vrps.common.dao.impl;

import com.ly.vrps.common.dao.BaseDao;
import com.ly.vrps.common.model.Type;

/**
 * 类型
 * @author sunkl
 * @date 2019年03月31日 10:45:31
 */
public interface TypeMapper extends BaseDao<Type> {
    int updateByPrimaryKey(Type record);
}
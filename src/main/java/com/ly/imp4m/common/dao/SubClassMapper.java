package com.ly.imp4m.common.dao;

import com.ly.imp4m.common.model.SubClass;

/**
 * @author sunkl
 * @date 2019年03月28日 00:18:21
 */
public interface SubClassMapper extends BaseDao<SubClass> {
    int updateByPrimaryKey(SubClass record);
}
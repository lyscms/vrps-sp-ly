package com.ly.imp4m.common.dao;

import com.ly.imp4m.common.model.SubClass;

/**
 * 子分类
 * @author sunkl
 * @date 2019年03月31日 10:45:31
 */
public interface SubClassMapper extends BaseDao<SubClass> {
    int updateByPrimaryKey(SubClass record);
}
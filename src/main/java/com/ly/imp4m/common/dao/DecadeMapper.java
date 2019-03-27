package com.ly.imp4m.common.dao;

import com.ly.imp4m.common.model.Decade;

/**
 * @author sunkl
 * @date 2019年03月28日 00:18:21
 */
public interface DecadeMapper extends BaseDao<Decade> {
    int updateByPrimaryKey(Decade record);
}
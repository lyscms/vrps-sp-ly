package com.ly.imp4m.common.dao;

import com.ly.imp4m.common.model.Raty;

/**
 * @author sunkl
 * @date 2019年03月28日 00:18:21
 */
public interface RatyMapper extends BaseDao<Raty> {
    int updateByPrimaryKey(Raty record);
}
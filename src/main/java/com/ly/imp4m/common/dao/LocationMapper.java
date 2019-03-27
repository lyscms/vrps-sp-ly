package com.ly.imp4m.common.dao;

import com.ly.imp4m.common.model.Location;

/**
 * @author sunkl
 * @date 2019年03月28日 00:18:21
 */
public interface LocationMapper extends BaseDao<Location> {
    int updateByPrimaryKey(Location record);
}
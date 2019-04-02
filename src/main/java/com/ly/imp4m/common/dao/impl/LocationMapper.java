package com.ly.imp4m.common.dao.impl;

import com.ly.imp4m.common.dao.BaseDao;
import com.ly.imp4m.common.model.Location;

/**
 * 地区
 * @author sunkl
 * @date 2019年03月31日 10:45:31
 */
public interface LocationMapper extends BaseDao<Location> {
    int updateByPrimaryKey(Location record);
}
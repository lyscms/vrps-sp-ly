package com.ly.imp4m.common.dao;

import com.ly.imp4m.common.model.Level;

/**
 * @author sunkl
 * @date 2019年03月28日 00:18:21
 */
public interface LevelMapper extends BaseDao<Level> {
    int updateByPrimaryKey(Level record);
}
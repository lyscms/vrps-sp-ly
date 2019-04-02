package com.ly.imp4m.common.dao.impl;

import com.ly.imp4m.common.dao.BaseDao;
import com.ly.imp4m.common.model.Level;

/**
 * 影片级别
 * @author sunkl
 * @date 2019年03月31日 10:45:31
 */
public interface LevelMapper extends BaseDao<Level> {
    int updateByPrimaryKey(Level record);
}
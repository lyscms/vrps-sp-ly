package com.ly.imp4m.common.dao.impl;

import com.ly.imp4m.common.dao.BaseDao;
import com.ly.imp4m.common.model.CataLog;

/**
 * 目录
 * @author sunkl
 * @date 2019年03月31日 10:45:31
 */
public interface CataLogMapper extends BaseDao<CataLog> {
    int updateByPrimaryKey(CataLog record);
}
package com.ly.vrps.common.dao.impl;

import com.ly.vrps.common.dao.BaseDao;
import com.ly.vrps.common.model.CataLog;

/**
 * 目录
 * @author sunkl
 * @date 2019年03月31日 10:45:31
 */
public interface CataLogMapper extends BaseDao<CataLog> {
    int updateByPrimaryKey(CataLog record);
}
package com.ly.vrps.common.dao.impl;

import com.ly.vrps.common.dao.BaseDao;
import com.ly.vrps.common.model.Raty;

/**
 * 评分
 * @author sunkl
 * @date 2019年03月31日 10:45:31
 */
public interface RatyMapper extends BaseDao<Raty> {
    int updateByPrimaryKey(Raty record);
}
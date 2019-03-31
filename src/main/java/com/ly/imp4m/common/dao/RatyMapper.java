package com.ly.imp4m.common.dao;

import com.ly.imp4m.common.model.Raty;

/**
 * 评分
 * @author sunkl
 * @date 2019年03月31日 10:45:31
 */
public interface RatyMapper extends BaseDao<Raty> {
    int updateByPrimaryKey(Raty record);
}
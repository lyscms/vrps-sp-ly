package com.ly.imp4m.common.dao.impl;

import com.ly.imp4m.common.dao.BaseDao;
import com.ly.imp4m.common.model.Res;

/**
 * 资源
 * @author sunkl
 * @date 2019年03月31日 20:56:34
 */
public interface ResMapper extends BaseDao<Res> {
    int updateByPrimaryKey(Res record);
}
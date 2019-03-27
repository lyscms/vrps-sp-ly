package com.ly.imp4m.common.dao;

import com.ly.imp4m.common.model.Resource;
import com.ly.imp4m.common.model.ResourceWithBLOBs;

/**
 * @author sunkl
 * @date 2019年03月28日 00:18:21
 */
public interface ResourceMapper extends BaseDao<Resource> {
    int updateByPrimaryKeyWithBLOBs(ResourceWithBLOBs record);

    int updateByPrimaryKey(Resource record);
}
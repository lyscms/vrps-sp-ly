package com.ly.imp4m.common.dao;

import com.ly.imp4m.common.model.Res;
import com.ly.imp4m.common.model.ResourceWithBLOBs;

/**
 * 资源
 * @author sunkl
 * @date 2019年03月31日 10:45:31
 */
public interface ResourceMapper extends BaseDao<Res> {
    int updateByPrimaryKeyWithBLOBs(ResourceWithBLOBs record);

    int updateByPrimaryKey(Res record);
}
package com.ly.imp4m.common.dao;

import com.ly.imp4m.common.model.Catalog;

/**
 * @author sunkl
 * @date 2019年03月28日 00:18:21
 */
public interface CatalogMapper extends BaseDao<Catalog> {
    int updateByPrimaryKey(Catalog record);
}
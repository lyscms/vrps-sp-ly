package com.ly.imp4m.common.dao;

import com.ly.imp4m.common.model.VipCode;

/**
 * @author sunkl
 * @date 2019年03月28日 00:18:21
 */
public interface VipCodeMapper extends BaseDao<VipCode> {
    int updateByPrimaryKey(VipCode record);
}
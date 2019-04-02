package com.ly.imp4m.common.dao.impl;

import com.ly.imp4m.common.dao.BaseDao;
import com.ly.imp4m.common.model.VipCode;

/**
 * vip编码
 * @author sunkl
 * @date 2019年03月31日 10:45:31
 */
public interface VipCodeMapper extends BaseDao<VipCode> {
    int updateByPrimaryKey(VipCode record);
}
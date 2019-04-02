package com.ly.imp4m.common.dao.impl;

import com.ly.imp4m.common.dao.BaseDao;
import com.ly.imp4m.common.model.Decade;

import java.util.List;

/**
 * 年份
 * @author sunkl
 * @date 2019年03月31日 10:45:31
 */
public interface DecadeMapper extends BaseDao<Decade> {
    int updateByPrimaryKey(Decade record);

    List<Decade> selectByIsUse(int isUse);
}
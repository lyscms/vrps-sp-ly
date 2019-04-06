package com.ly.vrps.common.dao.impl;

import com.ly.vrps.common.dao.BaseDao;
import com.ly.vrps.common.model.Decade;

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
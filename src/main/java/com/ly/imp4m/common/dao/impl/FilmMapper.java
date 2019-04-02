package com.ly.imp4m.common.dao.impl;

import com.ly.imp4m.common.dao.BaseDao;
import com.ly.imp4m.common.model.Film;

/**
 * 影片
 * @author sunkl
 * @date 2019年03月31日 10:45:31
 */
public interface FilmMapper extends BaseDao<Film> {
    int updateByPrimaryKeyWithBLOBs(Film record);

    int updateByPrimaryKey(Film record);
}
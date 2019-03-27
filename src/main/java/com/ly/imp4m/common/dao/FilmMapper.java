package com.ly.imp4m.common.dao;

import com.ly.imp4m.common.model.Film;

/**
 * @author sunkl
 * @date 2019年03月28日 00:18:21
 */
public interface FilmMapper extends BaseDao<Film> {
    int updateByPrimaryKeyWithBLOBs(Film record);

    int updateByPrimaryKey(Film record);
}
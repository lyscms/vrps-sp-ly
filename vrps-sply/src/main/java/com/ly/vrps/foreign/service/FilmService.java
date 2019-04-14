package com.ly.vrps.foreign.service;

import com.github.pagehelper.PageInfo;
import com.ly.vrps.common.model.Film;

import java.util.List;

/**
 * 影片service层接口
 *
 * @author 10589
 * @date 2016/10/4
 * @time 12:05
 */
public interface FilmService {
    String add(Film film);

    Film load(String filmId);

    boolean update(Film film);

    PageInfo<Film> getPage(Film ob, int pc, int ps);

    List<Film> listByTypeId(String type_id);

    List<Film> listByCataLogId(String id);

    List<Film> listByEvaluation(String id);

    int getCountAll();

    int getCountByCataLog(String id);

    List<Film> selectByCondition(Film film);
}

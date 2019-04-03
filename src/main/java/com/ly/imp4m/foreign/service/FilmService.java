package com.ly.imp4m.foreign.service;

import com.github.pagehelper.PageInfo;
import com.ly.imp4m.common.model.Film;

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

    Film load(String film_id);

    boolean update(Film film);

    PageInfo<Film> getPage(Film ob, int pc, int ps);

    List<Film> listByTypeId(String type_id);

    List<Film> listByCataLogId(String id);

    List<Film> listByEvaluation(String id);

    int getCountAll();

    int getCountByCataLog(String id);
}

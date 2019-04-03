package com.ly.imp4m.foreign.service;

import com.ly.imp4m.common.model.Raty;
import java.util.List;


/**
 * 评分service接口
 *
 * @author 10589
 * @date 2016/10/8
 * @time 12:52
 */
public interface RatyService {

    String  add(Raty raty);

    List<Raty> listALLByFilmId(String film_id);

    int getCountByFilm_id(String film_id);
}

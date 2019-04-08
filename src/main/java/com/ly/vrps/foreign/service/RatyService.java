package com.ly.vrps.foreign.service;

import com.ly.vrps.common.model.Raty;
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

    List<Raty> listALLByFilmId(String filmId);

    int getCountByfilmId(String filmId);
}

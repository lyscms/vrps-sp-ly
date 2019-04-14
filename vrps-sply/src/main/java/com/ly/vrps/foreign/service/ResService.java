package com.ly.vrps.foreign.service;

import com.ly.vrps.common.model.Res;
import java.util.List;

/**
 * 资源service层接口
 *
 * @author 10589
 * @date 2016/10/4
 * @time 12:07
 */
public interface ResService {
    String add(Res res);

    List<Res> listByFilmId(String filmId);

    boolean delete(String res_id);

    boolean updateIsUse(String res_id);

    List<Res> listByLinkType(String filmId, String linkType);
}

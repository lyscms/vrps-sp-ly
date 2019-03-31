package com.ly.imp4m.foreign.service;

import com.ly.imp4m.common.model.Res;
import java.util.List;

/**
 * 资源service层接口
 *
 * @author 10589
 * @date 2016/10/4
 * @time 12:07
 */
public interface IResService {
    String add(Res res);

    List<Res> listByfilm_id(String film_id);

    boolean delete(String res_id);

    boolean updateIsUse(String res_id);

    List<Res> listByLinkType(String film_id, String linkType);
}

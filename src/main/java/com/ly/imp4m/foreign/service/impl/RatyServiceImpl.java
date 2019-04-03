package com.ly.imp4m.foreign.service.impl;


import com.ly.imp4m.common.dao.impl.RatyMapper;
import com.ly.imp4m.common.model.Raty;
import com.ly.imp4m.foreign.service.RatyService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 评分service层接口实现
 *
 * @author 10589
 * @date 2016/10/8
 * @time 12:52
 */
@Component
public class RatyServiceImpl implements RatyService {
    @Resource
    private RatyMapper ratyMapper;

    @Override
    public String add(Raty raty) {
        return ratyMapper.insert(raty) > 0 ? raty.getId() : "0";
    }

    @Override
    public List<Raty> listALLByFilmId(String filmId) {
        Raty raty = new Raty();
        raty.setFilmId(filmId);
        return ratyMapper.select(raty);
    }

    @Override
    public int getCountByFilm_id(String filmId) {
        List<Raty> raties = listALLByFilmId(filmId);
        return CollectionUtils.isEmpty(raties)?0:raties.size();
    }
}

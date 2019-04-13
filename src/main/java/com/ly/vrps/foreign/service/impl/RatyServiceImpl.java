package com.ly.vrps.foreign.service.impl;


import com.ly.vrps.common.dao.impl.RatyMapper;
import com.ly.vrps.common.model.Raty;
import com.ly.vrps.foreign.service.RatyService;
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
        raty.beforeInsert();
        return ratyMapper.insert(raty) > 0 ? "1" : "0";
    }

    @Override
    public List<Raty> listALLByFilmId(String filmId) {
        Raty raty = new Raty();
        raty.setFilmId(filmId);
        return ratyMapper.select(raty);
    }

    @Override
    public int getCountByfilmId(String filmId) {
        List<Raty> raties = listALLByFilmId(filmId);
        return CollectionUtils.isEmpty(raties)?0:raties.size();
    }
}

package com.ly.imp4m.foreign.service.impl;

import com.ly.imp4m.foreign.service.IResService;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 资源service层接口实现
 *
 * @author 10589
 * @date 2016/10/4
 * @time 12:08
 */
@Component
public class ResService implements IResService {

    @Resource
    private ResourceMapper resourceMapper;

    @Override
    public String add(Res res) {
        res.setIsUse(1);
        res.setUpdateTime(new Date());
        return resourceMapper.insert(res) > 0 ? res.getId() : "0";
    }

    /**
     * 查询该film_id的资源
     * @param filmId
     * @return
     */
    @Override
    public List<Res> listByfilmId(String filmId) {
        Res res = new Res();
        res.setFilmId(filmId);
        return resourceMapper.selectSelective(res);
    }

    @Override
    public boolean delete(String resId) {
        return resourceMapper.deleteByPrimaryKey(resId) > 0;
    }

    /**
     * 更改在离线
     * @param resId
     * @return
     */
    @Override
    public boolean updateIsUse(String resId) {
        Res res = resourceMapper.selectByPrimaryKey(resId);
        int isUse = res.getIsUse();
        if (isUse == 1) {
            res.setIsUse(0);
        } else {
            res.setIsUse(1);
        }
        return resourceMapper.updateByPrimaryKeySelective(res) > 0;
    }

    @Override
    public List<Res> listByLinkType(String filmId,String linkType) {
        Res res = new Res();
        res.setFilmId(filmId);
        res.setLinkType(linkType);
        return resourceMapper.selectSelective(res);
    }
}

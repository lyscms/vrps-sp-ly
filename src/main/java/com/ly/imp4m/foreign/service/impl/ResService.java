package com.ly.imp4m.foreign.service.impl;

import com.ly.imp4m.common.dao.impl.ResMapper;
import com.ly.imp4m.common.model.Res;
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
    private ResMapper resMapper;

    @Override
    public String add(Res res) {
        res.setIsUse(1);
        res.setUpdateTime(new Date());
        return resMapper.insert(res) > 0 ? res.getId() : "0";
    }

    /**
     * 查询该film_id的资源
     * @param filmId
     * @return
     */
    @Override
    public List<Res> listByFilmId(String filmId) {
        Res res = new Res();
        res.setFilmId(filmId);
        return resMapper.select(res);
    }

    @Override
    public boolean delete(String resId) {
        return resMapper.deleteByPrimaryKey(resId) > 0;
    }

    /**
     * 更改在离线
     * @param resId
     * @return
     */
    @Override
    public boolean updateIsUse(String resId) {
        Res res = resMapper.selectByPrimaryKey(resId);
        int isUse = res.getIsUse();
        if (isUse == 1) {
            res.setIsUse(0);
        } else {
            res.setIsUse(1);
        }
        return resMapper.updateByPrimaryKeySelective(res) > 0;
    }

    @Override
    public List<Res> listByLinkType(String filmId,String linkType) {
        Res res = new Res();
        res.setFilmId(filmId);
        res.setLinkType(linkType);
        return resMapper.select(res);
    }
}

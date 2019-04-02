package com.ly.imp4m.common.service.impl;

import com.ly.imp4m.common.dao.BaseDao;
import com.ly.imp4m.common.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service层基类实现
 * @author sunkl
 * @date 2018/12/7
 */
@Service
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    private BaseDao<T> baseDao;

    @Override
    public int deleteByPrimaryKey(String id) {
        return baseDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(T t) {
        return baseDao.insert(t);
    }

    @Override
    public int insertSelective(T t) {
        return baseDao.insertSelective(t);
    }

    @Override
    public T selectByPrimaryKey(String id) {
        return baseDao.selectByPrimaryKey(id);
    }
}

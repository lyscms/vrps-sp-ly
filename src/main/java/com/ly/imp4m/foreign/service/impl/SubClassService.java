package com.ly.imp4m.foreign.service.impl;

import com.ly.imp4m.common.dao.SubClassMapper;
import com.ly.imp4m.common.model.SubClass;
import com.ly.imp4m.foreign.service.ISubClassService;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.List;

/**
 * 二级目录service层接口实现
 *
 * @author 10589
 * @date 2016/10/3
 * @time 18:33
 */
@Component
public class SubClassService implements ISubClassService {


    @Resource
    private SubClassMapper subClassMapper;


    @Override
    public String add(SubClass subClass) {
        return subClassMapper.insert(subClass) > 0 ? subClass.getId() : "0";
    }

    @Override
    public SubClass load(String subClassId) {
        return subClassMapper.selectByPrimaryKey(subClassId);
    }

    @Override
    public List<SubClass> listByCataLogId(String catalogId) {
        SubClass subClass = new SubClass();
        subClass.setCatalogId(catalogId);
        return subClassMapper.selectSelective(subClass);
    }

    @Override
    public List<SubClass> listIsUse(String catalogId) {
        SubClass subClass = new SubClass();
        subClass.setIsUse(1);
        subClass.setCatalogId(catalogId);
        return subClassMapper.selectSelective(subClass);
    }
}

package com.ly.vrps.foreign.service.impl;
import com.ly.vrps.common.dao.impl.TypeMapper;
import com.ly.vrps.common.model.Type;
import com.ly.vrps.foreign.service.TypeService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类型service层接口实现
 *
 * @author 10589
 * @date 2016/10/3
 * @time 18:25
 */
@Component
public class TypeServiceImpl implements TypeService {
    @Resource
    private TypeMapper typeMapper;

    @Override
    public String add(Type type) {
        type.beforeInsert();
        return typeMapper.insert(type) > 0 ? "1" : "0";
    }

    @Override
    public List<Type> listIsUse() {
        Type type = new Type();
        type.setIsUse(1);
        return typeMapper.select(type);
    }

    @Override
    public List<Type> listBySubClassId(String subClassId) {
        Type type = new Type();
        type.setSubclassId(subClassId);
        return typeMapper.select(type);
    }

    @Override
    public Type load(String typeId) {
        return typeMapper.selectByPrimaryKey(typeId);
    }

    @Override
    public List<Type> listIsUseBySubClassId(String subClassId) {
        Type type = new Type();
        type.setSubclassId(subClassId);
        type.setIsUse(1);
        return typeMapper.select(type);
    }
}

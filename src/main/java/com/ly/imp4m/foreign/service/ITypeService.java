package com.ly.imp4m.foreign.service;

import com.ly.imp4m.common.model.Type;
import java.util.List;

/**
 * 类型service层接口
 *
 * @author 10589
 * @date 2016/10/3
 * @time 18:25
 */
public interface ITypeService {
    String  add(Type type);

    List<Type> listIsUse();

    List<Type> listBySubClassId(String subClass_id);

    Type load(String val);

    List<Type> listIsUseBySubClassId(String subClass_id);
}

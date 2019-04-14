package com.ly.vrps.foreign.service;

import com.ly.vrps.common.model.Type;
import java.util.List;

/**
 * 类型service层接口
 *
 * @author 10589
 * @date 2016/10/3
 * @time 18:25
 */
public interface TypeService {
    String  add(Type type);

    List<Type> listIsUse();

    List<Type> listBySubClassId(String subClassId);

    Type load(String val);

    List<Type> listIsUseBySubClassId(String subClassId);
}

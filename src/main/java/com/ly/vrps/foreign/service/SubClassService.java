package com.ly.vrps.foreign.service;

import com.ly.vrps.common.model.SubClass;
import java.util.List;

/**
 * 二级目录service层接口
 *
 * @author 10589
 * @date 2016/10/3
 * @time 18:32
 */
public interface SubClassService {

    String add(SubClass subClass);

    SubClass load(String subClassId);

    List<SubClass> listByCataLogId(String cataLogId);

    List<SubClass> listIsUse(String cataLogId);

    List<SubClass> listIsUse(List<String> cataLogIdList);
}

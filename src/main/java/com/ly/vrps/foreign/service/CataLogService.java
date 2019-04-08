package com.ly.vrps.foreign.service;

import com.ly.vrps.common.model.CataLog;
import java.util.List;

/**
 * 一级目录service层接口
 *
 * @author 10589
 * @date 2016/10/3
 * @time 18:26
 */
public interface CataLogService {

    String  add(CataLog cataLog);

    List<CataLog> listIsUse();

    CataLog load(String cataLogId);

}

package com.ly.imp4m.foreign.service;

import com.ly.imp4m.common.model.CataLog;
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

    CataLog load(String cataLog_id);

}

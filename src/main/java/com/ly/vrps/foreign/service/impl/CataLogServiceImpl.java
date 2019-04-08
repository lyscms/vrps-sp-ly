package com.ly.vrps.foreign.service.impl;
import com.ly.vrps.common.dao.impl.CataLogMapper;
import com.ly.vrps.common.model.CataLog;
import com.ly.vrps.foreign.service.CataLogService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 一级目录service层接口实现
 *
 * @author 10589
 * @date 2016/10/3
 * @time 18:27
 */
@Component
public class CataLogServiceImpl implements CataLogService {

    @Resource
    private CataLogMapper cataLogMapper;

    /**
     * 添加一级目录
     * @param cataLog
     * @return
     */
    @Override
    public String add(CataLog cataLog) {
        cataLog.beforeInsert();
        return cataLogMapper.insert(cataLog) > 0 ? "1" : "0";
    }

    /**
     * 查询所有在使用的一级目录
     * @return
     */
    @Override
    public List<CataLog> listIsUse() {
        CataLog cataLog = new CataLog();
        cataLog.setIsUse(1);
        return cataLogMapper.select(cataLog);
    }

    @Override
    public CataLog load(String cataLogId) {
        return cataLogMapper.selectByPrimaryKey(cataLogId);
    }
}

package com.ly.imp4m.foreign.service.impl;
import com.ly.imp4m.common.dao.impl.CataLogMapper;
import com.ly.imp4m.common.model.CataLog;
import com.ly.imp4m.foreign.service.ICataLogService;
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
public class CataLogService implements ICataLogService {

    @Resource
    private CataLogMapper cataLogMapper;

    /**
     * 添加一级目录
     * @param cataLog
     * @return
     */
    @Override
    public String add(CataLog cataLog) {
        return cataLogMapper.insert(cataLog) > 0 ? cataLog.getId() : "0";
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
    public CataLog load(String cataLog_id) {
        return cataLogMapper.selectByPrimaryKey(cataLog_id);
    }
}

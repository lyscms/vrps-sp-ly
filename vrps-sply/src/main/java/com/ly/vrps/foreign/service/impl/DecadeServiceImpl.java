package com.ly.vrps.foreign.service.impl;

import com.ly.vrps.common.dao.impl.DecadeMapper;
import com.ly.vrps.common.model.Decade;
import com.ly.vrps.foreign.service.DecadeService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 年代service层接口实现
 *
 * @author 10589
 * @date 2016/10/3
 * @time 18:28
 */
@Component
public class DecadeServiceImpl implements DecadeService {

    @Resource
    private DecadeMapper decadeMapper;

    /**
     * 添加年代信息
     * @param decade
     * @return
     */
    @Override
    public String add(Decade decade) {
        decade.beforeInsert();
        return decadeMapper.insert(decade) > 0 ? "1" : "0";
    }

    /**
     * 查询在使用的年代
     * @return
     */
    @Override
    public List<Decade> listIsUse() {
        return decadeMapper.selectByIsUse(1);
    }
}

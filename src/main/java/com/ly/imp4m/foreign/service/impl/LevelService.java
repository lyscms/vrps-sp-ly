package com.ly.imp4m.foreign.service.impl;

import com.ly.imp4m.common.dao.impl.LevelMapper;
import com.ly.imp4m.common.model.Level;
import com.ly.imp4m.foreign.service.ILevelService;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.List;

/**
 * 级别service层接口实现
 * @author 10589
 * @date 2016/10/3
 * @time 18:29
 */
@Component
public class LevelService implements ILevelService {

    @Resource
    private LevelMapper levelMapper;

    /**
     * 添加级别
     *
     * @param level
     * @return
     */
    @Override
    public String add(Level level) {
        return levelMapper.insert(level) > 0 ? level.getId() : "0";
    }


    /**
     * 查询在使用的界别类型
     *
     * @return
     */
    @Override
    public List<Level> listIsUse() {
        Level level = new Level();
        level.setIsUse(1);
        return levelMapper.select(level);
    }
}

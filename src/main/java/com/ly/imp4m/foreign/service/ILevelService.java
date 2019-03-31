package com.ly.imp4m.foreign.service;

import com.ly.imp4m.common.model.Level;
import java.util.List;

/**
 * 级别service层接口
 *
 * @author 10589
 * @date 2016/10/3
 * @time 18:29
 */
public interface ILevelService {
    String add(Level level);

    List<Level> listIsUse();
}

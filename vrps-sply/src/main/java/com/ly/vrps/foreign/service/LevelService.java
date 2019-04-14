package com.ly.vrps.foreign.service;

import com.ly.vrps.common.model.Level;
import java.util.List;

/**
 * 级别service层接口
 *
 * @author 10589
 * @date 2016/10/3
 * @time 18:29
 */
public interface LevelService {
    String add(Level level);

    List<Level> listIsUse();
}

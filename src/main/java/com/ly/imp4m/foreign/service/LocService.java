package com.ly.imp4m.foreign.service;

import com.ly.imp4m.common.model.Location;
import java.util.List;

/**
 * 地区service层接口
 *
 * @author 10589
 * @date 2016/10/3
 * @time 18:30
 */
public interface LocService {
    String add(Location loc);

    List<Location> listIsUse();
}

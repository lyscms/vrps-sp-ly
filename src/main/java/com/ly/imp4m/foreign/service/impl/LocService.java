package com.ly.imp4m.foreign.service.impl;

import com.ly.imp4m.common.dao.LocationMapper;
import com.ly.imp4m.common.model.Location;
import com.ly.imp4m.foreign.service.ILocService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 地区service层接口实现
 *
 * @author 10589
 * @date 2016/10/3
 * @time 18:31
 */
@Component
public class LocService implements ILocService {

    @Resource
    private LocationMapper locationMapper;

    @Override
    public String add(Location loc) {
        return locationMapper.insert(loc) > 0 ? loc.getId() : "0";
    }

    @Override
    public List<Location> listIsUse() {
        Location location = new Location();
        location.setIsUse(1);
        return locationMapper.selectSelective(location);
    }
}

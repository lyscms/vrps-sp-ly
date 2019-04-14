package com.ly.vrps.foreign.service;

import com.ly.vrps.common.model.Decade;

import java.util.List;

/**
 * 年代service层接口
 *
 * @author 10589
 * @date 2016/10/3
 * @time 18:27
 */
public interface DecadeService {

    String add(Decade decade);

    List<Decade> listIsUse();
}

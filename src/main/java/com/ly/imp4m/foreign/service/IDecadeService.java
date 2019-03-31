package com.ly.imp4m.foreign.service;

import com.ly.imp4m.common.model.Decade;

import java.util.List;

/**
 * 年代service层接口
 *
 * @author 10589
 * @date 2016/10/3
 * @time 18:27
 */
public interface IDecadeService {

    String add(Decade decade);

    List<Decade> listIsUse();
}

package com.ly.vrps.foreign.service;

import com.ly.vrps.common.model.VipCode;
import java.util.List;

/**
 * 类型service层接口
 *
 * @author 10589
 * @date 2016/10/3
 * @time 18:25
 */
public interface VipCodeService {

    String  add(VipCode vipCode);

    List<VipCode> listIsUse();

    VipCode load(String val);

    int saveAll(List<VipCode> vipCodes);

    VipCode findByVipCode(String code);

    boolean update(VipCode vipCode);
}

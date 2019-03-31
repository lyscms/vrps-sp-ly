package com.ly.imp4m.foreign.service;

import com.ly.imp4m.common.model.VipCode;
import java.util.List;

/**
 * 类型service层接口
 *
 * @author 10589
 * @date 2016/10/3
 * @time 18:25
 */
public interface IVipCodeService {

    String  add(VipCode vipCode);

    List<VipCode> listIsUse();

    VipCode load(String val);

    int saveAll(List<VipCode> vipCodes);

    VipCode findByVipCode(String code);

    boolean update(VipCode vipCode);
}

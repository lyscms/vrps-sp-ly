package com.ly.imp4m.foreign.service;

import com.ly.imp4m.common.model.User;
import java.util.List;

/**
 * 类型service层接口
 *
 * @author 10589
 * @date 2016/10/3
 * @time 18:25
 */
public interface IUserService {

    User add(User user);

    List<User> listIsUse();

    User load(String id);

    int saveAll(List<User> users);

    List<User> findByCondition(User user);

    Boolean update(User user);
}

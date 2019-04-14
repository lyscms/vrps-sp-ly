package com.ly.vrps.foreign.service;

import com.ly.vrps.common.model.User;
import java.util.List;

/**
 * 类型service层接口
 *
 * @author 10589
 * @date 2016/10/3
 * @time 18:25
 */
public interface UserService {

    User add(User user);

    List<User> listIsUse();

    User load(String id);

    int saveAll(List<User> users);

    List<User> findByCondition(User user);

    Boolean update(User user);
}

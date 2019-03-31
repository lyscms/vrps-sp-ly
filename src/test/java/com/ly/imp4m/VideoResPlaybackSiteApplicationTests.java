package com.ly.imp4m;

import com.ly.imp4m.common.model.User;
import com.ly.imp4m.foreign.service.impl.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VideoResPlaybackSiteApplicationTests {

    @Resource
    private UserService userService;

    @Test
    public void contextLoads() {
        List<User> users = userService.listIsUse();
        Assert.assertNotNull(users);
    }

}

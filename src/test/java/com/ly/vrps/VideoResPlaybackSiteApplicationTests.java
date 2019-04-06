package com.ly.vrps;

import com.ly.vrps.common.model.User;
import com.ly.vrps.foreign.service.impl.UserServiceImpl;
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
    private UserServiceImpl userServiceImpl;

    @Test
    public void contextLoads() {
        List<User> users = userServiceImpl.listIsUse();
        Assert.assertNotNull(users);
    }

}

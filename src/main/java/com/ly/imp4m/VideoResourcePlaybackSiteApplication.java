package com.ly.imp4m;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 项目启动主入口
 * @author sunkl
 * @date 2019/3/24 19:00
 */
@MapperScan(basePackages = "com.ly.imp4m.common.dao")
@SpringBootApplication
public class VideoResourcePlaybackSiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(VideoResourcePlaybackSiteApplication.class, args);
    }

}

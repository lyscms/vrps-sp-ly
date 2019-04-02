package com.ly.imp4m;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;


/**
 * 项目启动主入口
 * @author sunkl
 * @date 2019/3/24 19:00
 */
@MapperScan(basePackages = "com.ly.imp4m.common.dao.impl")
@SpringBootApplication
public class VideoResourcePlaybackSiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(VideoResourcePlaybackSiteApplication.class, args);
    }

}

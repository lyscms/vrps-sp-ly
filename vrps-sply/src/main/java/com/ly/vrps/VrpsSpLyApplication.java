package com.ly.vrps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;


/**
 * 项目启动主入口
 * @author vrps
 * @date 2019/3/24 19:00
 */
@MapperScan(basePackages = "com.ly.vrps.common.dao.impl")
@SpringBootApplication
public class VrpsSpLyApplication {

    public static void main(String[] args) {
        SpringApplication.run(VrpsSpLyApplication.class, args);
    }
}

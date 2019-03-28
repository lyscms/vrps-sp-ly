package com.ly.imp4m.user.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义登录失败后处理
 * @author sunkl
 * @date 2018/12/23
 */
@Component
@Slf4j
public class LyAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) {

        //转发到根路径
        try {
            logger.info("登录失败");
            response.sendRedirect("/login");
        } catch (IOException e) {
            logger.error("登录失败,跳转失败");
        }
    }
}

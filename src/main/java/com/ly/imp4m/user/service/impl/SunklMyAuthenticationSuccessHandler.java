package com.ly.imp4m.user.service.impl;


import com.ly.imp4m.common.model.SysUser;
import com.ly.imp4m.common.util.EnvUtils;
import com.ly.imp4m.common.util.SpringContextUtils;
import com.ly.imp4m.user.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 自定义认证成功后处理
 * @author sunkl
 * @date 2018/12/23
 */
@Slf4j
@Service
public class SunklMyAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private RequestCache requestCache = new HttpSessionRequestCache();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,Authentication authentication) {
        logger.info("登录成功");
        try {
            String currentUserId = EnvUtils.getCurrentUserId();
            SysUserService sysUserService = (SysUserService) SpringContextUtils.getSpringBean("sysUserServiceImpl");
            SysUser sysUser = sysUserService.getSysUserInfo(currentUserId);
            sysUser.setLastLoginIpAddress(request.getRemoteAddr());
            sysUser.setLastLoginTime(new Date());
            Integer loginCount = sysUser.getLoginCount();
            if(loginCount==null){
                loginCount = 0;
            }
            sysUser.setLoginCount(loginCount+1);
            sysUserService.update(sysUser);

            SavedRequest savedRequest = requestCache.getRequest(request,response);
            String targetUrl = savedRequest.getRedirectUrl();
            getRedirectStrategy().sendRedirect(request,response,targetUrl);
            clearAuthenticationAttributes(request);
        } catch (Exception e) {
            log.error("更新用户登录信息错误：",e);
        }
    }
}



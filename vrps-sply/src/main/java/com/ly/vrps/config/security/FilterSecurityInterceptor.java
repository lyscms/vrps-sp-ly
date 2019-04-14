package com.ly.vrps.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;

import javax.servlet.*;
import java.io.IOException;

/**
 * 自定拦截器
 * @author sunkl
 * @date 2018/12/23
 */
@Service
public class FilterSecurityInterceptor extends AbstractSecurityInterceptor implements Filter {
 
    @Autowired
    private FilterInvocationSecurityMetadataSource securityMetadataSource;
 
    @Autowired
    public void setMyAccessDecisionManager(SpLyAccessDecisionManager spLyAccessDecisionManager) {
        super.setAccessDecisionManager(spLyAccessDecisionManager);
    }
 
 
    @Override
    public void init(FilterConfig filterConfig) {
 
    }
 
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        FilterInvocation fi = new FilterInvocation(request, response, chain);
        invoke(fi);
    }
 
 
    public void invoke(FilterInvocation fi) throws IOException, ServletException {
        InterceptorStatusToken token = super.beforeInvocation(fi);
        try {
        //执行下一个拦截器
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
        } finally {
            super.afterInvocation(token, null);
        }
    }
 
    @Override
    public void destroy() {
 
    }
 
    @Override
    public Class<?> getSecureObjectClass() {
        return FilterInvocation.class;
    }
 
    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return this.securityMetadataSource;
    }
}

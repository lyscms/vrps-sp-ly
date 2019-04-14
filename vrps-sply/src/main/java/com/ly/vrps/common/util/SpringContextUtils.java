package com.ly.vrps.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Spring容器工具类
 * @author sunkl
 * @date 2018/12/29
 */
@Component
public class SpringContextUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtils.applicationContext = applicationContext;
    }


    /**
     * 获取Spring容器的bean
     * @author sunkl
     * @date 2018/12/29
     * @param beanName
     * @return
     */
    public static Object getSpringBean(String beanName) {
        Object bean = SpringContextUtils.applicationContext.getBean(beanName);
        if (bean != null) {
            return bean;
        }
        return null;
    }
}

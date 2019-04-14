package com.ly.vrps.common.util;


import com.ly.vrps.config.security.SecurityUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 用户相关工具
 * @author sunkl
 * @date 2018/12/24
 */
public class EnvUtils {


    /**
     * 获取当前登录的Authentication
     * @author sunkl
     * @date 2018/12/24
     * @return
     */
    public static Authentication getCurrentAuthentication(){
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 获取当前登录用户
     * @author sunkl
     * @date 2018/12/24
     * @return
     */
    public static SecurityUser getCurrentUser(){
        Authentication currentAuthentication = getCurrentAuthentication();
        if (currentAuthentication != null && currentAuthentication.getPrincipal() != null) {
            return (SecurityUser)currentAuthentication.getPrincipal();
        }
        return null;
    }

    /**
     * 获取当前登录用户id
     * @author sunkl
     * @date 2018/12/24
     * @return
     */
    public static String getCurrentUserId(){
        SecurityUser currentUser = getCurrentUser();
        if(currentUser!=null){
            return currentUser.getId();
        }
        return null;
    }


    /**
     * 获取当前登录用户名
     * @author sunkl
     * @date 2018/12/24
     * @return
     */
    public static String getCurrentUserName(){
        SecurityUser currentUser = getCurrentUser();
        if(currentUser!=null){
            return currentUser.getName();
        }
        return null;
    }

    /**
     * 获取当前登录账号
     * @author sunkl
     * @date 2018/12/24
     * @return
     */
    public static String getCurrentAccount(){
        SecurityUser currentUser = getCurrentUser();
        if(currentUser!=null){
            return currentUser.getAccount();
        }
        return null;
    }
}

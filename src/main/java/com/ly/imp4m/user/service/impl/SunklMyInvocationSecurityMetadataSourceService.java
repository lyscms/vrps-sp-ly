package com.ly.imp4m.user.service.impl;
 
import com.ly.imp4m.common.model.SysPermission;
import com.ly.imp4m.user.service.SysPermissionService;
import com.ly.imp4m.user.web.vo.SysPermissionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 权限信息提供
 * @author sunkl
 * @date 2018/12/23
 */
@Service
public class SunklMyInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {
 

    private HashMap<String, Collection<ConfigAttribute>> map =null;

    @Autowired
    private SysPermissionService sysPermissionService;

    /**
     * 加载权限表中所有权限
     */
    public void loadResourceDefine(){
        map = new HashMap<>(16);
        Collection<ConfigAttribute> array;
        ConfigAttribute cfg;
        List<SysPermissionVo> permissions = sysPermissionService.selectSysPermissionInfo(new SysPermission());
        for(SysPermissionVo permission : permissions) {
            array = new ArrayList<>();
            cfg = new SecurityConfig(permission.getId());
            //此处只添加了用户的名字，其实还可以添加更多权限的信息，
            // 例如请求方法到ConfigAttribute的集合中去。此处添加的信息将会作为SunklMyAccessDecisionManager类的decide的第三个参数。
            array.add(cfg);
            //用权限的getUrl() 作为map的key，用ConfigAttribute的集合作为 value，
            if(!StringUtils.isEmpty(permission.getUrl())){
                map.put(permission.getUrl(), array);
            }
        }
    }

    /**
     * 此方法是为了判定用户请求的url 是否在权限表中，
     * 如果在权限表中，则返回给 decide 方法，用来判定用户是否有此权限。
     * 如果不在权限表中则放行。
     * @param object
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        if (map == null) {
            loadResourceDefine();
        }
        //object 中包含用户请求的request 信息
        HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
        AntPathRequestMatcher matcher;
        String resUrl;
        Iterator<String> iter = map.keySet().iterator();
        while (iter.hasNext()) {
            resUrl = iter.next();
            matcher = new AntPathRequestMatcher(resUrl);
            if (matcher.matches(request)) {
                return map.get(resUrl);
            }
        }
        return null;
    }
 
    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }
 
    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}

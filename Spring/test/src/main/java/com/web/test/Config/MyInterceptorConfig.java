package com.web.test.Config;

import com.web.test.Mapper.RoleMapper;
import com.web.test.Mapper.UserMapper;
import com.web.test.MyInterceptor;
import com.web.test.Util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyInterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private RoleMapper roleMapper;


    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor(roleMapper,jwtTokenUtil))
                .addPathPatterns("/admin-api/**"); // 设置拦截的URL模式
    }
}
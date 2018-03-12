package com.eivencrm.spring.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.eivencrm.interceptors.UserLoginHandlerInterceptor;


@Configuration
public class SpringMVCConfig extends WebMvcConfigurerAdapter {
    
    @Autowired
    private UserLoginHandlerInterceptor userLoginHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	System.out.println("判断用户是否登录的拦截器");
        // 判断用户是否登录的拦截器
        registry.addInterceptor(userLoginHandlerInterceptor).addPathPatterns("/**");
    }

}

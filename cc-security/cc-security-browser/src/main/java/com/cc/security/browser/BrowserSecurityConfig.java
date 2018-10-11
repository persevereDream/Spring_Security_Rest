package com.cc.security.browser;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()              //表单登陆
//          http.httpBasic()              //基础登陆、弹出窗口
                .and()
                .authorizeRequests()    //下方配置都是要授权的
                .anyRequest()           //所有请求
                .authenticated();       //需要身份认证
    }
}

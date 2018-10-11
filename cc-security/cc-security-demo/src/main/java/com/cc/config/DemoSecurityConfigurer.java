package com.cc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;



//@Configuration
//@EnableWebSecurity
//public class DemoSecurityConfigurer extends WebSecurityConfigurerAdapter {
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        // 设置不拦截规则
////        web.ignoring().antMatchers("/**");
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                //.passwordEncoder(new MessageDigestPasswordEncoder("MD5"))
////                .withUser("user").password("{MD5}e10adc3949ba59abbe56e057f20f883e").roles("USER");
//        .withUser(User.withDefaultPasswordEncoder().username("user").password("password").roles("USER"));
//    }
//}

package com.cc.security.browser;

import com.cc.security.core.SecurityProperties;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.*;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private SecurityProperties securityProperties;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()    //表单登陆
//          http.httpBasic()
                .loginPage("/authentication/require")   //配置登陆页面地址（可以是html的静态地址，也可以是Controller的动态请求）
                .loginProcessingUrl("/authentication/form") //发出这个请求时,通知UsernamePasswordAuthenticationFilter处理这个请求
            .and()
            .authorizeRequests()    //下方配置都是要授权的
                .antMatchers("/authentication/require",
                        securityProperties.getBrowser().getLoginPage()  //配置的登陆页面放权
                            ).permitAll()
                .anyRequest()   //所有请求
                .authenticated()    //需要身份认证
            .and()
            .csrf().disable();  //关闭跨域请求防护
    }

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return createDelegatingPasswordEncoder("MD5");
    }


    public static PasswordEncoder createDelegatingPasswordEncoder(String encodingId) {

        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put("bcrypt", new BCryptPasswordEncoder());
        encoders.put("ldap", new LdapShaPasswordEncoder());
        encoders.put("MD4", new Md4PasswordEncoder());
        encoders.put("MD5", new MessageDigestPasswordEncoder("MD5"));
        encoders.put("noop", NoOpPasswordEncoder.getInstance());
        encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
        encoders.put("scrypt", new SCryptPasswordEncoder());
        encoders.put("SHA-1", new MessageDigestPasswordEncoder("SHA-1"));
        encoders.put("SHA-256", new MessageDigestPasswordEncoder("SHA-256"));
        encoders.put("sha256", new StandardPasswordEncoder());
        if (StringUtils.isBlank(encodingId))
            encodingId = "noop";
        return encoders.get(encodingId);
    }

}

package com.cc.security.browser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyUserDetailsService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(MyUserDetailsService.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("登陆用户名："+username);
        //根据用户名查找用户信息
        String password = passwordEncoder.encode("123456");
        logger.info("登陆用户数据库中密码："+password);
        List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("admin");
        //根据查到的用户信息判断用户是否被冻结
        boolean enable = true;                 //false:用户已失效
        boolean accountNonExpired = true;      //false:用户帐号已过期
        boolean credentialsNonExpired = true;  //false:用户凭证(密码)已过期
        boolean accountNonLocked = true;       //false:用户帐号已被锁定
        return new User(username,password,enable,accountNonExpired,credentialsNonExpired,accountNonLocked,authorities);
//        return new User(username,password,authorities);
    }
}

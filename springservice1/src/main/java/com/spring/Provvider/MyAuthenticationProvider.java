package com.spring.Provvider;

import com.spring.Service.ServiceImpl.JwtUserDetailsServiceImpl;
import com.spring.Until.Md5Util;
import com.spring.controller.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @Auther: CQ02
 * @Date: 2018/10/11 16:18
 * @Description:
 */
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private JwtUserDetailsServiceImpl jwtUserDetailsService;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        UserDetails user = jwtUserDetailsService.loadUserByUsername(username);
        if(user == null){
            throw new BadCredentialsException("用户没有找到");
        }
        //加密过程在这里体现
        if (!Md5Util.md5(password).equals(user.getPassword())) {
            System.out.print("密码错误");
            throw new BadCredentialsException("密码错误");
        }

        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        return new UsernamePasswordAuthenticationToken(user, password, authorities);

    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}

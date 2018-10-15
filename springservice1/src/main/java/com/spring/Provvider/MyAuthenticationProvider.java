package com.spring.Filter;

import com.spring.controller.UserController;
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
    private UserController userController=new UserController();
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        UserDetails user = userController.loadUserByUsername(username);
        if(user == null){
            throw new BadCredentialsException("用户没有找到");
        }

        //加密过程在这里体现
        if (!password.equals(user.getPassword())) {
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

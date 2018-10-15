package com.spring.Service.ServiceImpl;

import com.spring.Entity.User;
import com.spring.Mapper.IUserRepository;
import com.spring.Provvider.MyAuthenticationProvider;
import com.spring.Service.UserService;
import com.spring.Until.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * @Auther: CQ02
 * @Date: 2018/10/12 15:56
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private MyAuthenticationProvider myAuthenticationProvider;
    @Autowired
    private JwtUserDetailsServiceImpl jwtUserDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public String login(User user) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        Authentication authentication = myAuthenticationProvider.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(user.getUserName());
        return jwtTokenUtil.generateToken(userDetails);
    }
}

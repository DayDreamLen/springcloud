package com.spring.Service.ServiceImpl;

import com.spring.Entity.JwtUser;
import com.spring.Entity.User;
import com.spring.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


/**
 * @Auther: CQ02
 * @Date: 2018/10/12 16:26
 * @Description:
 */
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    private UserMapper userRepository;

    @Autowired
    public JwtUserDetailsServiceImpl(UserMapper userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        List<String> roleList=userRepository.findRoleById(user.getId());
        user.setRoles(roleList);
        System.out.println();
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return new JwtUser(user.getUserName(), user.getPassword(), user.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
        }
    }

}



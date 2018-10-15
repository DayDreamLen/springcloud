package com.spring.Mapper;

import com.spring.Entity.User;
import org.springframework.stereotype.Component;

/**
 * @Auther: CQ02
 * @Date: 2018/10/12 16:33
 * @Description:
 */
@Component
public interface IUserRepository {
    /**
     * 通过用户名查找用户
     *
     * @param username 用户名
     * @return 用户信息
     */
    User findByUserName(String username);
}

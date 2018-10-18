package com.spring.Mapper;

import com.spring.Entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: CQ02
 * @Date: 2018/10/12 16:33
 * @Description:
 */
public interface UserMapper {
    /**
     * 通过用户名查找用户
     *
     * @param username 用户名
     * @return 用户信息
     */
    User findByUserName(@Param("userName") String username);
    /**
     * 通过用户id查找角色
     *
     * @param id 用户id
     * @return 角色信息
     */
    List<String> findRoleById(@Param("id") long id);
}

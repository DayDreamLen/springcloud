package com.spring.Service;

import com.spring.Entity.User;
import com.spring.controller.RequestModel.UserRequestModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

/**
 * @Auther: CQ02
 * @Date: 2018/10/12 15:56
 * @Description:
 */
public interface UserService {
    public String login(UserRequestModel user);
}

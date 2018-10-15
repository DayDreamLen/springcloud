package com.spring.controller;


import com.spring.Entity.User;
import com.spring.Provvider.MyAuthenticationProvider;
import com.spring.Service.UserService;
import com.spring.controller.ResponseModel.UserReponseModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: CQ02
 * @Date: 2018/10/11 16:17
 * @Description:
 */
@Controller
@Api
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/user/login")
   public @ResponseBody UserReponseModel login(@RequestBody User user){
       String token=userService.login(user);
       return new UserReponseModel(user.getUserName(),token);
   }
}

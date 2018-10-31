package com.spring.example.service;

import com.spring.example.controller.RequestModel.PowerRequestModel;
import com.spring.example.controller.RequestModel.UserRequestModel;
import com.spring.example.controller.ResponseModel.PowerResponseModel;
import com.spring.example.controller.ResponseModel.ResponseBean;
import com.spring.example.controller.ResponseModel.UserReponseModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Auther: CQ02
 * @Date: 2018/10/23 10:43
 * @Description:
 */
@Component
@FeignClient(value = "spring-service")

public interface Uservice {
//    @PostMapping("/springservice/index")
//    public PowerResponseModel login(@RequestBody PowerRequestModel powerRequestModel);

    @PostMapping("/user/login")
    public ResponseBean<UserReponseModel> login(@RequestBody UserRequestModel user);
}

package com.spring.controller;

import com.google.gson.Gson;
import com.spring.Util.Constant;
import com.spring.Util.JwtUtils;
import com.spring.controller.RequestModel.UserReuqestModel;
import com.spring.controller.ResponseModel.LoginResponseModel;
import com.spring.controller.ResponseModel.ResponseBean;
import com.spring.controller.constant.StatusCode;
import io.swagger.annotations.ApiOperation;
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
public class UserController  {
    @PostMapping("/mylogin")
    @ApiOperation("/mylogin")
    public @ResponseBody
    ResponseBean<LoginResponseModel> login(@RequestBody UserReuqestModel params){
        ResponseBean<LoginResponseModel> responseBean = new ResponseBean<LoginResponseModel>(StatusCode.OK);
        try {

            //生成token
            String token = JwtUtils.createJWT(Constant.JWT_ID, "", new Gson().toJson("aaaa"), Constant.JWT_TTL);
            responseBean.setData(new LoginResponseModel(token));
        } catch (Exception e) {
            return new ResponseBean<>(StatusCode.JWT_ERRCODE_FAIL);
        }
        return responseBean;
    }
}

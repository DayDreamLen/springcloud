package com.spring.controller;

import com.spring.controller.RequestModel.PowerRequestModel;
import com.spring.controller.ResponseModel.PowerResponseModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: CQ02
 * @Date: 2018/10/8 15:09
 * @Description:
 */
@Api("/data/v1")
@Controller
public class PowerController {
    @PostMapping("/index")
    @ApiOperation("test")
    public @ResponseBody PowerResponseModel index(@RequestBody PowerRequestModel powerRequestModel){

        return new PowerResponseModel("test1001");
    }
}

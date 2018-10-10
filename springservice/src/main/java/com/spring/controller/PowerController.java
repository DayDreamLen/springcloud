package com.spring.controller;

import com.spring.controller.RequestModel.PowerRequestModel;
import com.spring.controller.ResponseModel.PowerResponseModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: CQ02
 * @Date: 2018/10/8 15:09
 * @Description:
 */
@Api
@Controller
public class PowerController {
    @ApiOperation(value = "test")
    @PostMapping("/index1000")
    public @ResponseBody PowerResponseModel index(@RequestParam PowerRequestModel powerRequestModel){

        return new PowerResponseModel("test");
    }
}

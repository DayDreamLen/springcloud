package com.spring.controller;

import com.spring.controller.RequestModel.PowerRequestModel;
import com.spring.controller.ResponseModel.PowerResponseModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        System.out.println("2111");
        return new PowerResponseModel("test");
    }
}

package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: CQ02
 * @Date: 2018/10/8 15:09
 * @Description:
 */
@Controller
public class PowerController {
    @Autowired
    RestTemplate restTemplate;
    @RequestMapping("index")
    public @ResponseBody
    String index(){
//        List<Map<String,String>> list=new ArrayList<>();
//        Map<String,String> map=new HashMap<>();
//        map.put("test","test");
//        list.add(map);
//        return list;
        ResponseEntity<String> responseEntity=restTemplate.getForEntity("http://localhost:1001/index1001",String.class);
        return responseEntity.getBody();
    }
}

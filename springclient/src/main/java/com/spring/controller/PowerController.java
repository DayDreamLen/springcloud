package com.spring.controller;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
    @JsonDeserialize
     static class  ResponseModel{
        public String test;

        public String getTest() {
            return test;
        }

        public void setTest(String test) {
            this.test = test;
        }
    }
    class Testaa{
        public String test;
        public Long id;

        public String getTest() {
            return test;
        }

        public void setTest(String test) {
            this.test = test;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }
    @RequestMapping("index")
    public @ResponseBody
    ResponseModel index(){
//        List<Map<String,String>> list=new ArrayList<>();
//        Map<String,String> map=new HashMap<>();
//        map.put("test","test");
//        list.add(map);
//        return list;
        String test="test";
        Long id=111L;
        Testaa testaa=new Testaa();
        testaa.setId(id);
        testaa.setTest(test);
        ResponseEntity<ResponseModel> responseEntity=restTemplate.postForEntity("http://SPRING-SERVICE/index",
                testaa,ResponseModel.class);
        return responseEntity.getBody();
    }
}

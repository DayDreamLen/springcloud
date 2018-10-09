package com.spring.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: CQ02
 * @Date: 2018/10/8 15:09
 * @Description:
 */
@Configuration
public class PowerConfig {
    @Bean
    public TomcatServletWebServerFactory tomcatServletWebServerFactory(){
       TomcatServletWebServerFactory tomcat= new TomcatServletWebServerFactory();
       tomcat.setPort(2000);
       return tomcat;
    }
    @Bean
    public RestTemplate  restTemplate(){
        RestTemplate restTemplate=new RestTemplate();
        return  restTemplate;
    }
}

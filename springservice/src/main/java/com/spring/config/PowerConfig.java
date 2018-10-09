package com.spring.config;

import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
       tomcat.setPort(1000);
       return tomcat;
    }
}

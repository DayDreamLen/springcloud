package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Auther: CQ02
 * @Date: 2018/10/8 15:15
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
public class ApplicationStart  {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStart.class);
    }
}

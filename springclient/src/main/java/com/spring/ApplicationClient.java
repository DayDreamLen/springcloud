package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: CQ02
 * @Date: 2018/10/8 15:15
 * @Description:
 */
@SpringBootApplication
public class ApplicationClient {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationClient.class);
    }
    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

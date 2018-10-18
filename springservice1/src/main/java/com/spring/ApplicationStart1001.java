package com.spring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Auther: CQ02
 * @Date: 2018/10/8 15:15
 * @Description:
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableTransactionManagement
@MapperScan("com.spring.mapper")
public class ApplicationStart1001 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStart1001.class);
    }
}

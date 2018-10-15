package com.spring.config;

import com.spring.interceptor.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @Auther: CQ02
 * @Date: 2018/10/12 14:40
 * @Description:
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Bean
    public HandlerInterceptor getMyInterceptor(){
        return new MyInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(getMyInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/swagger-ui.html")
                .excludePathPatterns("/v2/api-docs/**")
                .excludePathPatterns("/swagger-resources/**")
                .excludePathPatterns("/webjars/springfox-swagger-ui/**")
                .excludePathPatterns("/mylogin");
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry){
//
//        registry.addResourceHandler("/swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/");
//
//    }

}

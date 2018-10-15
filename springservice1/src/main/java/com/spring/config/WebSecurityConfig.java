package com.spring.config;

import com.spring.Filter.MacLoginUrlAuthenticationEntryPoint;
import com.spring.Filter.MyAuthenticationProvider;
import com.spring.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;

/**
 * @Auther: CQ02
 * @Date: 2018/10/11 14:58
 * @Description:
 */
@Configuration
//开启security注解
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyAuthenticationProvider authenticationProvider;



    @Autowired
    private MyInterceptor myInterceptor;

    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //允许访问项目主路径/的请求
        //其它请求都要经过拦截验证
        //同时也允许注销请求
        //支持表单验证登录
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.POST,"/mylogin").permitAll()
                .anyRequest().authenticated()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().authenticationEntryPoint( macLoginUrlAuthenticationEntryPoint())
                .and()
                .formLogin()
                    .permitAll();
        //取消掉默认的csrf认证
        http.csrf().disable();
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
      web.ignoring().antMatchers("/v2/api-docs/**","/swagger-resources/**",
              "/webjars/springfox-swagger-ui/**","/v2/api-docs/**","/swagger-ui.html");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
//      auth.userDetailsService(customUserDetailsService()).passwordEncoder(passwordEncoder());passwordEncoder
    }

    @Bean
    public AuthenticationEntryPoint macLoginUrlAuthenticationEntryPoint() {
        return new MacLoginUrlAuthenticationEntryPoint("/login/index");
    }

    @Bean
    public  MyInterceptor myInterceptor(){
        return new MyInterceptor();
    }


}

package com.spring.interceptor;

import com.spring.Util.JwtUtils;
import com.spring.controller.ResponseModel.ResponseBean;
import com.spring.except.TokenInvalidException;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MyInterceptor implements HandlerInterceptor {
    //在请求处理之前进行调用（Controller方法调用之前
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) {
        System.out.printf("preHandle被调用");
        try {
            String headerToken = httpServletRequest.getHeader("X-Auth-Token");

            //获取请求参数中token
            String requetToken = httpServletRequest.getParameter("X-Auth-Token");
            if (StringUtils.isEmpty(headerToken)) {
                throw new TokenInvalidException();
                //return false;
            } else {
                ResponseBean responseBean = JwtUtils.validateJWT(headerToken);
                if (!responseBean.isSuccess()) {
                    throw new TokenInvalidException();
                } else {
                    return true;    //如果false，停止流程，api被拦截
                }
            }
        } catch (TokenInvalidException e) {
            throw new TokenInvalidException();
        }
    }

    //请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle被调用");
    }

    //在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion被调用");
    }
}

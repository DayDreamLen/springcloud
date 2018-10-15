package com.spring.controller.ResponseModel;

/**
 * @Auther: CQ02
 * @Date: 2018/10/11 16:42
 * @Description:
 */
public class LoginResponseModel {
    private String token;

    public LoginResponseModel(String token) {
        this.token = token;
    }

    public LoginResponseModel() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

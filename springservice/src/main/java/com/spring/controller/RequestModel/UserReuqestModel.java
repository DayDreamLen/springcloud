package com.spring.controller.RequestModel;

/**
 * @Auther: CQ02
 * @Date: 2018/10/11 16:43
 * @Description:
 */
public class UserReuqestModel {
    private String userName;
    private String password;
    private String code;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

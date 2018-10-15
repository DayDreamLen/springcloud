package com.spring.controller.ResponseModel;

import lombok.Data;

/**
 * @Auther: CQ02
 * @Date: 2018/10/15 09:46
 * @Description:
 */
@Data
public class UserReponseModel {
    private String userName;
    private String token;

    public UserReponseModel(String userName, String token) {
        this.userName = userName;
        this.token = token;
    }
}

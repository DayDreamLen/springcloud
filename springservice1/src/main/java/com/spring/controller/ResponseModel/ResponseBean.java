package com.spring.controller.ResponseModel;

import com.spring.controller.constant.StatusCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yunfei.li
 *         类描述: TODO
 *         日期： 2018/6/8
 */
@Data
@ApiModel("基础响应实体")
public class ResponseBean<T> {
    @ApiModelProperty("状态码")
    private int code;
    @ApiModelProperty("数据")
    private T data;
    @ApiModelProperty("信息")
    private String message;
    @ApiModelProperty("请求状态")
    private boolean success;
    @ApiModelProperty("请求Id")
    private String requestId;

    public ResponseBean() {
    }

    public ResponseBean(boolean success) {
        this.success = success;
        if (this.success) {
            setCode(StatusCode.OK.code());
            setMessage(StatusCode.OK.message());
        }
    }

    public ResponseBean(int code) {
        this.success = (StatusCode.OK.code() == code);
        this.code = code;
        this.message = StatusCode.valueOf(code) == null ? null : StatusCode.valueOf(code).message();
    }

    public ResponseBean(int code, String message) {
        this.success = (StatusCode.OK.code() == code);
        this.code = code;
        this.message = message;
    }

    public ResponseBean(StatusCode statusCode) {
        this(statusCode.code());
    }

    public ResponseBean(T data) {
        this(true);
        this.data = data;
    }

    public ResponseBean(StatusCode statusCode, String message) {
        this(statusCode.code(), message);
    }
}

package com.spring.controller.constant;

import com.cqdev.poverty.RestStatus;
import com.google.common.collect.ImmutableMap;

/**
 * @author wd
 */
public enum StatusCode implements RestStatus {

    OK(200, "请求成功"),

    /**
     * 系统错误
     */
    SYSTEM_ERROR(999, "系统错误"),

    /**
     * Mybatis错误
     */
    MYBATIS_ERROR(-200, "Mybatis错误"),
    /**
     * 未知错误
     */
    UNKNOWN_ERROR(-100, "未知错误"),

    // 40xxx 客户端不合法的请求
    INVALID_MODEL_FIELDS(40001, "字段校验非法"),
    /**
     * 不支持的请求方式
     */
    INVALID_METHOD(40000, "不支持的请求方式"),

    /**
     * 参数类型非法，常见于SpringMVC中String无法找到对应的enum而抛出的异常
     */
    INVALID_PARAMS_CONVERSION(40002, "参数类型非法"),
    /**
     * 权限错误
     */
    AUTHORITY_ERROR(40003, "数据权限错误"),

    /**
     * 数据不存在
     */
    DATA_NOT_EXIST(40004, "数据不存在"),

    /**
     * 手机号不存在
     */
    NOT_PHONE_EXIST(40005, "手机号不存在"),

    /**
     * jwt返回code
     */
    JWT_ERRCODE_EXPIRE(40006, "token已经过期"),

    JWT_ERRCODE_FAIL(40007, "签名校验失败"),
    /**
     * 重复数据
     */
    DATA_REPEAT_ERROR(40008, "存在重复数据"),
    /**
     * excel导入失败
     */
    FILE_ERROR(40009,"excel导入失败"),
    /**
     * 用户名活密码错误
     */
    ACCOUNT_PASSWORD__ERROR(40010, "用户名或密码错误"),
    /**
     * 验证码错误
     */
    CODE_ERROR(40011,"验证码不正确！"),
    /**
     * 验证码错误
     */
    CODE_FAIL(40012,"验证码验证失败！"),

    /**
     * 上传文件错误
     */
    UPLOADFILE_ERROR(40013, "上传文件错误！");


    private final int code;

    private final String message;

    private static final ImmutableMap<Integer, StatusCode> CACHE;

    static {
        final ImmutableMap.Builder<Integer, StatusCode> builder = ImmutableMap.builder();
        for (StatusCode statusCode : values()) {
            builder.put(statusCode.code(), statusCode);
        }
        CACHE = builder.build();
    }

    StatusCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static StatusCode valueOfCode(int code) {
        final StatusCode status = CACHE.get(code);
        if (status == null) {
            throw new IllegalArgumentException("No matching constant for [" + code + "]");
        }
        return status;
    }

    public static StatusCode valueOf(int code) {
        return CACHE.get(code);
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }

}

package com.spring.except;

/**
 * @author yunfei.li
 *         类描述: TODO
 *         日期： 2018/6/14
 */
public class DataRepeatException extends RuntimeException {

    public DataRepeatException(String message) {
        super(message);
    }
}

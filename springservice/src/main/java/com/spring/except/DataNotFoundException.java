package com.cqdev.poverty.biz.except;

/**
 * @author yunfei.li
 *         类描述: TODO
 *         日期： 2018/6/14
 */
public class DataNotFoundException extends RuntimeException {

    public DataNotFoundException(String message) {
        super(String.format(message));
    }
}

package com.cqdev.poverty.biz.except;

/**
 * @author yunfei.li
 *         类描述: TODO
 *         日期： 2018/6/15
 */
public class TokenInvalidException extends RuntimeException{

    public TokenInvalidException() {
        super();
    }

    public TokenInvalidException(String message) {
        super(message);
    }
}

package com.cqdev.poverty.utils;

import java.util.UUID;

public class Constant {
    public static final String JWT_ID = UUID.randomUUID().toString();
    /**
     * 加密密文
     */
    public static final String JWT_SECRET = "y!b@p#a$qwe%q^1&3*4(5)6<7W>?;EDA";
    /**
     * 有效时间
     */
    public static final int JWT_TTL = 60*60*1000;//millisecond
}

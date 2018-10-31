package com.spring.controller.constant;

/**
 * Created by 31321 on 2018-07-20.
 */
public enum DataEnum {
    CARTEMPLATE("car-template.xlsx"),
    BUSINESSTEMPLATE("business-template.xlsx"),
    FISCALTEMPLATE("fiscal-template.xlsx"),
    HOUSETEMPLATE("house-template.xlsx");

    DataEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    private String code;

}

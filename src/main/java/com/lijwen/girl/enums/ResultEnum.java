package com.lijwen.girl.enums;

public enum ResultEnum {

    UNKONWN_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    PRIMARY_SCHOOL(100, "你可能还在上小学"),
    MIDDLE_SCHOOL(101, "你可能在上初中"),

    ;
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    // 枚举不需要set方法，因为枚举的使用都是直接用构造方法创建，不会用set赋值。
    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

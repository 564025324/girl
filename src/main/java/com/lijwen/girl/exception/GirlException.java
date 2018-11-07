package com.lijwen.girl.exception;

public class GirlException extends RuntimeException {
    // spring只对RuntimeException异常进行回滚，对Exception异常不会进行回滚
    private Integer code;

    public GirlException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

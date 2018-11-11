package com.lijwen.girl.exception;

import com.lijwen.girl.enums.ResultEnum;

public class GirlException extends RuntimeException {
    // spring只对RuntimeException异常进行回滚，对Exception异常不会进行回滚
    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

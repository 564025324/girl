package com.lijwen.girl.handle;

import com.lijwen.girl.domail.Result;
import com.lijwen.girl.exception.GirlException;
import com.lijwen.girl.util.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHangle {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof GirlException) {
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getCode(), e.getMessage());
        } else {
            return ResultUtil.error(100, e.getMessage());
        }
    }
}

package com.lijwen.girl.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * 异常捕获
 */
@ControllerAdvice
public class ExceptionHandle {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

//    @ExceptionHandler(value = Exception.class)
//    @ResponseBody
//    public Result handle(Exception e) {
//        if (e instanceof GirlException) {
//            GirlException girlException = (GirlException) e;
//            return ResultUtil.error(girlException.getCode(), e.getMessage());
//        } else {
//            logger.error("[系统异常]{}", e);
//            return ResultUtil.error(-1, "未知错误");
//        }
//    }
}

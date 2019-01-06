package com.linshenkx.quick.demo.advice;

import com.linshenkx.quick.demo.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @version V1.0
 * @author: lin_shen
 * @date: 2017/12/4
 * @Description: TODO
 */
@ControllerAdvice
@Slf4j
public class ExceptionControllerAdvice {
    /**
     * 全局异常捕捉处理
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result errorHandler(Exception e){
        log.error("",e);
        return new Result(false,e.getMessage());
    }
}

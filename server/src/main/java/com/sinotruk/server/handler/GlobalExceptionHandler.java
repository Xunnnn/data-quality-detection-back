package com.sinotruk.server.handler;

import com.sinotruk.server.exception.ParamsException;
import com.sinotruk.server.model.RespBean;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author Tiechui Wang
 * @Date 2022-03-22 19:18
 * @description 全局异常处理
 */

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(ParamsException.class)
    @ResponseBody
    public RespBean paramsExceptionHandler(ParamsException e) {
        return RespBean.error(e.getMessage());
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public RespBean exceptionHandler(Exception e) {
        return RespBean.error(e.getMessage());
    }
}

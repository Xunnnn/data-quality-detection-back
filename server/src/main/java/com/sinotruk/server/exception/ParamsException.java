package com.sinotruk.server.exception;

/**
 * @Author Tiechui Wang
 * @Date 2022-03-22 18:27
 * @description
 */

public class ParamsException extends RuntimeException{
    private Integer code = 300;
    private String msg = "参数异常";
    
    public ParamsException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public ParamsException(Integer code) {
        super("参数异常");
        this.code = code;
    }

    public ParamsException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

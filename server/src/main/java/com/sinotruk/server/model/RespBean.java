package com.sinotruk.server.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Tiechui Wang
 * @Date 2022-03-22 18:11
 * @description 公共返回对象
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RespBean {
    private int code;
    private String message;
    private Object obj;

    /**
     * 成功返回结果
     * @param message
     * @return
     */
    public static RespBean success(String message) {
        return new RespBean(200, message, null);
    }
    
    public static RespBean success(String message, Object obj) {
        return new RespBean(200, message, obj);
    }

    /**
     * 失败返回结果
     * @param message
     * @return
     */
    public static RespBean error(String message) {
        return new RespBean(500, message, null);
    }
    
    public static RespBean error(String message, Object obj) {
        return new RespBean(500, message, obj);
    }
}

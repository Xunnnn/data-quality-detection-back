package com.sinotruk.server.utils;

import com.sinotruk.server.exception.ParamsException;

/**
 * @Author Tiechui Wang
 * @Date 2022-03-22 18:26
 * @description
 */

public class AssertUtil {
    public static void isTrue(boolean flag, String msg) {
        if (flag)
            throw new ParamsException(msg);
    }
}

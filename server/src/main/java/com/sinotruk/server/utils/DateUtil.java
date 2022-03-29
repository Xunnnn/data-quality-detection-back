package com.sinotruk.server.utils;

import com.sinotruk.server.exception.ParamsException;

import java.sql.Date;
import java.util.Calendar;

/**
 * @Author Tiechui Wang
 * @Date 2022-03-25 19:09
 * @description
 */

public class DateUtil {
    /**
     * 字符串转Sql.Date
     * @param date
     * @return
     */
    public static Date String2SqlDate(String date) {
        Date dDate = null;
        try {
            dDate = Date.valueOf(date);
        } catch (IllegalArgumentException e) {
            throw new ParamsException("数据格式异常");
        }
        return dDate;
    }

    /**
     * 计算若干天前的日期
     * @param date 基准日期
     * @param timeInterval 多少天前的日期
     * @return
     */
    public static Date getLastDaysDate(String date, int timeInterval) {
        Date dDate = DateUtil.String2SqlDate(date);
        Calendar calendar = new Calendar.Builder().setDate(dDate.getYear(), dDate.getMonth(), dDate.getDay()).build();
        calendar.add(Calendar.DAY_OF_MONTH, -timeInterval);
        return new Date(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
    }
}

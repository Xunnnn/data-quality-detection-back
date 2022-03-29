package com.sinotruk.server.service;

import com.sinotruk.server.pojo.DataqualityDays;
import com.baomidou.mybatisplus.extension.service.IService;

import java.sql.Date;
import java.util.List;

/**
 * <p>
 * 数据质量分日汇总表 服务类
 * </p>
 *
 * @author 王铁锤
 * @since 2022-03-25
 */
public interface IDataqualityDaysService extends IService<DataqualityDays> {

    // 查询指定日期数据
    DataqualityDays queryOneDayData(String date);

    // 查询指定日期i天前至今的所有数据
    List<DataqualityDays> queryPastDaysData(String date, Integer timeInterval);

    DataqualityDays queryOneByDate(Date date); // 根据日期查询
    List<DataqualityDays> queryDataBetweenDate(Date startDate, Date endDate); // 查询时间段内数据
}

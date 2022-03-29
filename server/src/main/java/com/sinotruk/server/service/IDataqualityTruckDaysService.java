package com.sinotruk.server.service;

import com.sinotruk.server.dto.TopTruckDataDTO;
import com.sinotruk.server.pojo.DataqualityTruckDays;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 数据质量车辆分日汇总表 服务类
 * </p>
 *
 * @author 王铁锤
 * @since 2022-03-26
 */
public interface IDataqualityTruckDaysService extends IService<DataqualityTruckDays> {

    // 查询 date 日期各项指标排名前 topNum 的车辆数据
    TopTruckDataDTO queryTopTruckData(String date, Integer topNum);
}

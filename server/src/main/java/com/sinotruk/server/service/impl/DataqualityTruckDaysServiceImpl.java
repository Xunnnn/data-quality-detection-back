package com.sinotruk.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sinotruk.server.dto.TopTruckDataDTO;
import com.sinotruk.server.pojo.DataqualityTruckDays;
import com.sinotruk.server.mapper.DataqualityTruckDaysMapper;
import com.sinotruk.server.service.IDataqualityTruckDaysService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sinotruk.server.utils.DateUtil;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * <p>
 * 数据质量车辆分日汇总表 服务实现类
 * </p>
 *
 * @author 王铁锤
 * @since 2022-03-26
 */
@Service
public class DataqualityTruckDaysServiceImpl extends ServiceImpl<DataqualityTruckDaysMapper, DataqualityTruckDays> implements IDataqualityTruckDaysService {

    @Override
    public TopTruckDataDTO queryTopTruckData(String date, Integer topNum) {
        Date dDate = DateUtil.String2SqlDate(date);
        if (topNum == null) // 默认排名前5数据
            topNum = 5;
        // 丢包率排名车
        List<DataqualityTruckDays> topLossRateTruck = this.baseMapper.selectList(new QueryWrapper<DataqualityTruckDays>().select("vin", "loss_rate").eq("op_date", dDate).orderByDesc("loss_rate").last("limit " + topNum.toString()));
        // 延时排名车
        List<DataqualityTruckDays> topDelayTruck = this.baseMapper.selectList(new QueryWrapper<DataqualityTruckDays>().select("vin", "delaytime").eq("op_date", dDate).orderByDesc("delaytime").last("limit " + topNum.toString()));
        return new TopTruckDataDTO(topLossRateTruck, topDelayTruck);
    }
}

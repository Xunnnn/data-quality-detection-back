package com.sinotruk.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sinotruk.server.mapper.DataqualityDaysMapper;
import com.sinotruk.server.pojo.DataqualityDays;
import com.sinotruk.server.service.IDataqualityDaysService;
import com.sinotruk.server.utils.AssertUtil;
import com.sinotruk.server.utils.DateUtil;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * <p>
 * 数据质量分日汇总表 服务实现类
 * </p>
 *
 * @author 王铁锤
 * @since 2022-03-25
 */
@Service
public class DataqualityDaysServiceImpl extends ServiceImpl<DataqualityDaysMapper, DataqualityDays> implements IDataqualityDaysService {
    @Override
    public DataqualityDays queryOneByDate(Date date) {
        return this.baseMapper.selectOne(new QueryWrapper<DataqualityDays>().eq("op_date", date));
    }

    @Override
    public List<DataqualityDays> queryDataBetweenDate(Date startDate, Date endDate) {
        return this.baseMapper.selectList(new QueryWrapper<DataqualityDays>().select("op_date", "abnorcnt", "loss_truckrate", "loss_datarate").between("op_date", startDate, endDate));
    }

    @Override
    public DataqualityDays queryOneDayData(String date) {
        Date dDate = DateUtil.String2SqlDate(date);
        DataqualityDays data = this.queryOneByDate(dDate);
        AssertUtil.isTrue(data == null, "未查询到" + date + "相关数据！");
        return data;
    }

    @Override
    public List<DataqualityDays> queryPastDaysData(String date, Integer timeInterval) {
        if (timeInterval == null) // 默认查询30天内数据
            timeInterval = 30;
        Date endDate = DateUtil.String2SqlDate(date);
        AssertUtil.isTrue(null == endDate, "数据格式不正确！");
        Date startDate = DateUtil.getLastDaysDate(date, timeInterval);
        List<DataqualityDays> data = queryDataBetweenDate(startDate, endDate);
        AssertUtil.isTrue(data == null, "未查询到相关数据！");
        return data;
    }
}

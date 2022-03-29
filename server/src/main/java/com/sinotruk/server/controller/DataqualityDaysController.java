package com.sinotruk.server.controller;


import com.sinotruk.server.model.RespBean;
import com.sinotruk.server.pojo.DataqualityDays;
import com.sinotruk.server.service.IDataqualityDaysService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 数据质量分日汇总表 前端控制器
 * </p>
 *
 * @author 王铁锤
 * @since 2022-03-25
 */
@Api("数据质量日统计相关指标接口")
@RestController
@RequestMapping("/dataquality-days")
@CrossOrigin(originPatterns = "*", methods = {RequestMethod.GET})
public class DataqualityDaysController {

    @Resource
    private IDataqualityDaysService service;

    @ApiOperation(value="查询单日数据质量结果", notes="单日数据质量结果", produces="application/json")
    @GetMapping("queryOneDayData")
    @ApiImplicitParam(name = "date", value = "查询日期", required = true, dataType = "String", example = "2022-03-14")
    public RespBean queryOneDay(String date) {
        DataqualityDays data = service.queryOneDayData(date);
        return RespBean.success("查询成功！", data);
    }

    @ApiOperation(value="查询过去30日数据统计结果", notes="过去30日数据统计结果", produces="application/json")
    @GetMapping("queryPastDaysData")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "date", value = "查询日期", required = true, dataType = "String", example = "2022-03-14"),
            @ApiImplicitParam(name = "timeInterval", value = "时间段长度，默认30天", required = false, dataType = "Integer", example = "30", defaultValue = "30")
    })
    public RespBean queryPast30DaysData(String date, Integer timeInterval) {
        List<DataqualityDays> list = service.queryPastDaysData(date, timeInterval);
        return RespBean.success("查询成功", list);
    }
}

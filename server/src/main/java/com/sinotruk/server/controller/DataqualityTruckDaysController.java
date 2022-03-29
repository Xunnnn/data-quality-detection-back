package com.sinotruk.server.controller;


import com.sinotruk.server.dto.TopTruckDataDTO;
import com.sinotruk.server.model.RespBean;
import com.sinotruk.server.service.IDataqualityTruckDaysService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 数据质量车辆分日汇总表 前端控制器
 * </p>
 *
 * @author 王铁锤
 * @since 2022-03-26
 */
@RestController
@RequestMapping("/dataquality-truck-days")
@CrossOrigin(originPatterns = "*", methods = {RequestMethod.GET})
public class DataqualityTruckDaysController {
    
    @Resource
    IDataqualityTruckDaysService service;

    @ApiOperation(value="查询前topNum名车相关信息数据", notes="查询前topNum名车相关信息数据", produces="application/json")
    @GetMapping("queryTopTruckData")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "date", value = "最后一天日期", required = true, dataType = "String", example = "2022-03-14"),
            @ApiImplicitParam(name = "topNum", value = "取前多少名车辆数据，默认取前5名", required = false, dataType = "Integer", defaultValue = "5", example = "10")
    })
    public RespBean queryTopTruckData(String date, Integer topNum) {
        TopTruckDataDTO topTruckData = service.queryTopTruckData(date, topNum);
        return RespBean.success("查询成功！", topTruckData);
    }
}

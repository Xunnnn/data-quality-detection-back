package com.sinotruk.server.dto;

import com.sinotruk.server.pojo.DataqualityTruckDays;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Tiechui Wang
 * @Date 2022-03-26 11:05
 * @description 查询排名前n的车辆信息返回对象
 */

@Data
@AllArgsConstructor
public class TopTruckDataDTO {
    private List<DataqualityTruckDays> topLossRateTruck;
    private List<DataqualityTruckDays> topDelayTruck;

}

package com.sinotruk.server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author Tiechui Wang
 * @Date 2022-03-26 11:12
 * @description 排名前n的单车车辆信息
 */

@Data
@AllArgsConstructor
public class TopTruckData {
    
    private String date;
    private String vin;
    private double rate;
}

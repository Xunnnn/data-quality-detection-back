package com.sinotruk.server.pojo;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 数据质量车辆分日汇总表
 * </p>
 *
 * @author 王铁锤
 * @since 2022-03-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("DW_Dataquality_Truck_Days")
@ApiModel(value="DataqualityTruckDays对象", description="数据质量车辆分日汇总表")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DataqualityTruckDays implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "数据日期")
    private LocalDate opDate;

    @ApiModelProperty(value = "车辆vin码")
    private String vin;

    @ApiModelProperty(value = "车辆今日数据信息汇总")
    private String datainfo;

    @ApiModelProperty(value = "正常数据条数")
    private Integer normalCnt;

    @ApiModelProperty(value = "应该有多少条数据")
    private Integer shouldCnt;

    @ApiModelProperty(value = "数据入库时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "延时平均时间(s)")
    private Integer delaytime;

    @ApiModelProperty(value = "丢包率")
    private BigDecimal lossRate;

    @ApiModelProperty(value = "异常状态，0正常，1异常")
    private String abnormalStatus;


}

package com.sinotruk.server.pojo;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigInteger;
import java.time.LocalDate;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 数据质量分日汇总表
 * </p>
 *
 * @author 王铁锤
 * @since 2022-03-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ST_Dataquality_Days")
@ApiModel(value="DataqualityDays对象", description="数据质量分日汇总表")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DataqualityDays implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "数据日期")
    private LocalDate opDate;

    @ApiModelProperty(value = "上线车辆数")
    private Integer onlinecnt;

    @ApiModelProperty(value = "过去7天上线车辆平均数")
    private Integer lsdOnlinecnt;

    @ApiModelProperty(value = "异常车辆数")
    private Integer abnorcnt;

    @ApiModelProperty(value = "过去7天异常车辆平均数(last seven days abnomal cnt)")
    private Integer lsdAbnorcnt;

    @ApiModelProperty(value = "数据非完整车辆数")
    private Integer unintcnt;

    @ApiModelProperty(value = "过去7天数据非完整车辆平均数")
    private Integer lsdUnintcnt;

    @ApiModelProperty(value = "数据非有效车辆数")
    private Integer invalcnt;

    @ApiModelProperty(value = "过去7天数据非有效车辆平均数")
    private Integer lsdInvalcnt;

    @ApiModelProperty(value = "延时车辆数")
    private Integer delaycnt;

    @ApiModelProperty(value = "过去7天延时车辆平均数")
    private Integer lsdDelaycnt;

    @ApiModelProperty(value = "每条数据包的延时平均值(s)")
    private Integer delayavg;

    @ApiModelProperty(value = "数据非准确车辆数")
    private Integer unacccnt;

    @ApiModelProperty(value = "过去7天非准确车辆平均数")
    private Integer lsdUnacccnt;

    @ApiModelProperty(value = "质量整体得分")
    private Integer qaScore;

    @ApiModelProperty(value = "数据总条数")
    private BigInteger datacnt;

    @ApiModelProperty(value = "过去7天数据总条数")
    private BigInteger lsdDatacnt;

    @ApiModelProperty(value = "异常数据条数")
    private Integer abnordatacnt;

    @ApiModelProperty(value = "过去7天异常数据条数")
    private Integer lsdAbnordatacnt;

    @ApiModelProperty(value = "当日丢包车辆数")
    private Integer lossTruckcnt;

    @ApiModelProperty(value = "丢包车辆率(%)")
    private BigDecimal lossTruckrate;

    @ApiModelProperty(value = "单车平均丢包率(%)")
    private BigDecimal lossAvgrate;

    @ApiModelProperty(value = "数据总丢包率(%)")
    private BigDecimal lossDatarate;

    @ApiModelProperty(value = "过去7天平均丢包率(%)")
    private BigDecimal lsdLosavgrate;

    @ApiModelProperty(value = "过去7天丢包车辆率平均值(%)")
    private BigDecimal lsdLostrurate;

    @ApiModelProperty(value = "过去7天数据总丢包率(%)平均值")
    private BigDecimal lsdLosdatrate;

    @ApiModelProperty(value = "过去7天数据数据延时平均值(s)")
    private Integer lsdDelavg;


}

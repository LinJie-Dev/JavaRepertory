package com.hjpz.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName : OrderVo
 * @Description : 运单实体
 * @Author : 林杰
 * @Date: 2020-04-25 13:56
 */
@ApiModel(description = "运单实体")
@Data
public class OrderVo implements Serializable {

    @ApiModelProperty(value = "运单号")
    private String orderNumber;

    @ApiModelProperty(value = "件数")
    private Integer pieces;

    @ApiModelProperty(value = "重量")
    private BigDecimal weight;

    @ApiModelProperty(value = "体积")
    private BigDecimal volume;
}

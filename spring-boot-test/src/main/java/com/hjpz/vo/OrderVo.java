package com.hjpz.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName : OrderVo
 * @Description : 运单实体
 * @Author : 林杰
 * @Date: 2020-04-25 13:56
 */
@Data
public class OrderVo implements Serializable {

    private String orderNumber;

    private Integer pieces;

    private BigDecimal weight;

    private BigDecimal volume;
}

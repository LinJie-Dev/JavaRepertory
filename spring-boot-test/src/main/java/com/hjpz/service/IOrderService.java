package com.hjpz.service;

import com.hjpz.vo.OrderVo;

/**
 * @description 运单对外暴露接口
 * @author 林杰
 * @date 2020/4/25 16:00
 * @version V1.0
 */
public interface IOrderService {
    /**
     * 查询运单信息
     * @param orderNumber 运单号
     * @return 运单信息
     */
    OrderVo queryOrderVoByOrderId(String orderNumber);
}

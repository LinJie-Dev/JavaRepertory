package com.hjpz.service.impl;

import com.hjpz.dao.IOrderDao;
import com.hjpz.service.IOrderService;
import com.hjpz.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName : OrderServiceImpl
 * @Description : 运单服务类
 * @Author : 林杰
 * @Date: 2020-04-25 16:06
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderDao orderDao;

    /**
     * @description 查询运单信息
     * @author 林杰
     * @date 2020/4/25 16:07
     * @version V1.0
     * @param orderNumber 运单号
     * @return 运单信息
     */
    @Override
    public OrderVo queryOrderVoByOrderId(String orderNumber) {
        return orderDao.queryOrderByOrderId(orderNumber);
    }
}

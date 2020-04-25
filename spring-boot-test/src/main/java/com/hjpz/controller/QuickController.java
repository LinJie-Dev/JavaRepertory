package com.hjpz.controller;

import com.hjpz.dao.IOrderDao;
import com.hjpz.service.IOrderService;
import com.hjpz.vo.OrderVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : QuickController
 * @Description : 快速启动测试
 * @Author : 林杰
 * @Date: 2020-04-25 13:26
 */
@RestController
@RequestMapping("/quick")
public class QuickController {

    @Autowired
    private IOrderService orderService;

    private Logger logger = LoggerFactory.getLogger(QuickController.class);

    @GetMapping("/{orderNumber}")
    public OrderVo quickTest(@PathVariable("orderNumber") String orderNumber) {
        logger.info("快速测试入口!。。。单号为：{}", orderNumber);
        return orderService.queryOrderVoByOrderId(orderNumber);
    }
}

package com.hjpz.controller;

import com.hjpz.service.IOrderService;
import com.hjpz.utils.ResponseBase;
import com.hjpz.vo.OrderVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName : QuickController
 * @Description : 快速启动测试
 * @Author : 林杰
 * @Date: 2020-04-25 13:26
 */
@Api(tags = "运单管理")
@RestController
@RequestMapping("/quick")
public class QuickController {

    @Autowired
    private IOrderService orderService;

    private Logger logger = LoggerFactory.getLogger(QuickController.class);

    @ApiOperation(value = "查询运单信息",notes = "根据运单号查询运单信息(运单号不为空)",httpMethod = "GET")
    @ApiImplicitParam(dataType = "string",name = "orderNumber",value = "运单号",required = true)
    @GetMapping("")
    public ResponseBase<OrderVo> quickTest(@RequestParam("orderNumber") String orderNumber) {
        logger.info("快速测试入口!。。。单号为：{}", orderNumber);
        return ResponseBase.success(orderService.queryOrderVoByOrderId(orderNumber));
    }
}

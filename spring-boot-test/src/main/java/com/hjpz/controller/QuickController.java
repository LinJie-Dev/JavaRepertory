package com.hjpz.controller;

import com.alibaba.fastjson.JSON;
import com.hjpz.service.IOrderService;
import com.hjpz.utils.EmptyUtils;
import com.hjpz.utils.JSONUtils;
import com.hjpz.utils.RedisUtil;
import com.hjpz.utils.ResponseBase;
import com.hjpz.vo.OrderVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class QuickController {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private RedisUtil redisUtil;

    @ApiOperation(value = "查询运单信息",notes = "根据运单号查询运单信息(运单号不为空)",httpMethod = "GET")
    @ApiImplicitParam(dataType = "string",name = "orderNumber",value = "运单号",required = true)
    @GetMapping("")
    public ResponseBase<OrderVo> quickTest(@RequestParam("orderNumber") String orderNumber) {
        if (EmptyUtils.isEmpty(orderNumber)) {
            return ResponseBase.fail("运单号为空!");
        }
        log.info("快速测试入口!。。。单号为：{}", orderNumber);
        String s = redisUtil.get("Method:quickTest;OrderNumber:" + orderNumber);
        if (EmptyUtils.isNotEmpty(s)) {
            log.info("-----quickTest缓存查询!-----");
            return ResponseBase.success(JSONUtils.getObject(s, OrderVo.class));
        }
        OrderVo orderVo = orderService.queryOrderVoByOrderId(orderNumber);
        if (EmptyUtils.isEmpty(orderVo)) {
            return ResponseBase.fail("运单查询参数为空!");
        }
        log.info("-----quickTest数据库查询!-----");
        redisUtil.set("Method:quickTest;OrderNumber:" + orderNumber, JSON.toJSONString(orderVo), 20);
        return ResponseBase.success(orderVo);
    }
}

package com.hjpz.controller;

import com.hjpz.utils.RedisUtil;
import com.hjpz.utils.ResponseBase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : RedisController
 * @Description : Redis工具类
 * @Author : 林杰
 * @Date: 2020-04-27 10:14
 */
@Api(tags = "Redis工具类")
@RestController
@RequestMapping("/redis")
@Slf4j
public class RedisController {

    @Autowired
    private RedisUtil redisUtil;

    @ApiOperation(value = "放入Redis",notes = "根据Key放入Value(Key不为空)",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string",name = "key",value = "RedisKey",required = true),
            @ApiImplicitParam(dataType = "string",name = "value",value = "RedisValue",required = true)
    })
    @PostMapping("/set")
    public ResponseBase<String> set(String key, String value, long time) {
        log.info("放入Redis缓存!!! key：{}, value：{}, time：{}", key, value, time);
        this.redisUtil.set(key, value, time);
        return ResponseBase.success("success");
    }

    @ApiOperation(value = "取出Redis",notes = "根据Key取Value(Key不为空)",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string",name = "key",value = "RedisKey",required = true)
    })
    @GetMapping("/get")
    public ResponseBase<String> get(String key) {
        log.info("Redis缓存取出!!! key：{}", key);
        return ResponseBase.success(this.redisUtil.get(key));
    }
}

package com.hjpz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
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

    private Logger logger = LoggerFactory.getLogger(QuickController.class);

    @GetMapping
    public String quickTest() {
        logger.info("快速测试入口!。。。");
        return "快速测试，启动成功!";
    }
}

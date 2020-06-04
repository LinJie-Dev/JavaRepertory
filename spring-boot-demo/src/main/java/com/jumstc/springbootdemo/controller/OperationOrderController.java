package com.jumstc.springbootdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname OperationOrderController
 * @Description TODO
 * @Date 2020/6/4 15:31
 * @Auther 林杰
 */
@RestController
@RequestMapping("/order")
public class OperationOrderController {

    @GetMapping("/queryOrderTestById/{id}")
    public String queryOrderTestById(@PathVariable Long id) {
        return "Hello SpringBoot is ok!";
    }
}

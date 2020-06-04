package com.jumstc.springbootboleui.controller.operation;

import com.jumstc.springbootboleui.model.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname OperationOrderController
 * @Description 运单管理
 * @Date 2020/6/4 16:01
 * @Auther 林杰
 */
@Api(tags = "运单管理")
@RestController
@RequestMapping("/order")
public class OperationOrderController {

    @ApiOperation(value = "查询运单信息")
    @GetMapping("/queryUserVoById/{id}")
    public UserVo queryUserVoById(@PathVariable("id") Long id) {
        UserVo userVo = new UserVo();
        userVo.setId(1L);
        userVo.setUserName("林杰");
        userVo.setAge(10);
        return userVo;
    }
}

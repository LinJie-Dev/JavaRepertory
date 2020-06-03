package com.jumstc.controller;
import com.jumstc.model.UserVo;
import com.jumstc.service.IOperationOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Classname OperationTestController
 * @Description 测试类
 * @Date 2020/6/3 11:35
 * @Auther 林杰
 */
@Controller
@RequestMapping("/operation")
public class OperationTestController {

    @Autowired
    private IOperationOrderService operationOrderService;

    @RequestMapping(value = "/selectOrderVoById/{id}", method = RequestMethod.GET)
    public UserVo selectOrderVoById(@PathVariable("id") Long id) {
        return operationOrderService.selectOrderVoById(id);
    }

    @RequestMapping("/select")
    public ModelAndView selectUser() {
        ModelAndView mv = new ModelAndView();
        UserVo user = operationOrderService.selectOrderVoById(1L);
        mv.addObject("user", user);
        mv.setViewName("index");
        return mv;
    }
}

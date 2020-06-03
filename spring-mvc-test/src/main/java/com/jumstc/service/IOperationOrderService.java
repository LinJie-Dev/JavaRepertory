package com.jumstc.service;

import com.jumstc.model.UserVo;

/**
 * @Classname IOperationOrderService
 * @Description 测试接口类
 * @Date 2020/6/3 11:43
 * @Auther 林杰
 */
public interface IOperationOrderService {

    /**
     * 查询运单实体
     * @param id 主键id
     * @return 字符串
     */
    UserVo selectOrderVoById(Long id);
}

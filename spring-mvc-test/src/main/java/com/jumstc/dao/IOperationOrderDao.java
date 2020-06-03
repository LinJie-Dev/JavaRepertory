package com.jumstc.dao;

import com.jumstc.model.UserVo;

/**
 * @Classname IOperationOrderDao
 * @Description TODO
 * @Date 2020/6/3 11:49
 * @Auther 林杰
 */
public interface IOperationOrderDao {

    /**
     * 查询运单信息
     * @param id 主键id
     * @return
     */
    UserVo selectOrderVoById(Long id);
}

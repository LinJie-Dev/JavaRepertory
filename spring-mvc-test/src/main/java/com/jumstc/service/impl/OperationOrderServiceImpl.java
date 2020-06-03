package com.jumstc.service.impl;

import com.jumstc.dao.IOperationOrderDao;
import com.jumstc.model.UserVo;
import com.jumstc.service.IOperationOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname OperationOrderServiceImpl
 * @Description TODO
 * @Date 2020/6/3 11:47
 * @Auther 林杰
 */
@Service
public class OperationOrderServiceImpl implements IOperationOrderService {

    @Autowired
    private IOperationOrderDao operationOrderDao;

    /**
     * 查询运单信息
     * @param id 主键id
     * @return
     */
    @Override
    public UserVo selectOrderVoById(Long id) {
        return operationOrderDao.selectOrderVoById(id);
    }
}

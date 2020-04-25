package com.hjpz.dao;

import com.hjpz.vo.OrderVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @ClassName : IOrderDao
 * @Description : 运单相关接口
 * @Author : 林杰
 * @Date: 2020-04-25 14:02
 */
@Mapper
public interface IOrderDao {

    /**
     * 查询运单信息
     * @param orderNumber 运单号
     * @return 运单信息
     */
    OrderVo queryOrderByOrderId(@Param("orderNumber") String orderNumber);
}

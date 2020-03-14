package com.cloud.dao;

import com.cloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author
 * @date 2020/3/12
 */
@Mapper
public interface IOrderDao {
    /**
     * 创建订单
     * @param order
     */
    void createOrder(Order order);

    /**
     * 更新订单状态
     * @param userId
     * @param status
     */
    void updateOrder(@Param("userId") Long userId, @Param("status") Integer status);
}

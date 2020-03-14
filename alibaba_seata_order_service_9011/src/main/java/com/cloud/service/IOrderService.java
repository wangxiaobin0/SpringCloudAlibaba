package com.cloud.service;

import com.cloud.domain.Order;

/**
 * @author
 * @date 2020/3/12
 */
public interface IOrderService {

    /**
     * 创建订单
     * @param order
     */
    void createOrder(Order order);
}

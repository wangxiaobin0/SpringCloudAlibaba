package com.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.cloud.domain.CommonResult;
import com.cloud.domain.Order;
import com.cloud.service.IAccountService;
import com.cloud.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * @date 2020/3/12
 */
@Slf4j
@RestController
public class OrderController {

    @Autowired
    IOrderService orderService;

    @PostMapping("/order")
    @SentinelResource(value = "order", fallback = "createOrderFallBack")
    public CommonResult createOrder(Order order) {
        orderService.createOrder(order);
        return new CommonResult("200", "订单创建成功");
    }

    public CommonResult createOrderFallBack(Order order, Throwable t) {
        log.info(t.getClass().getCanonicalName());
        return new CommonResult("500", "订单创建失败");
    }
}

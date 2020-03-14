package com.cloud.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.cloud.service.impl.PaymentServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * @date 2020/3/9
 */
@FeignClient(value = "alibaba-nacos-payment-service", fallback = PaymentServiceImpl.class)
public interface IPaymentService {

    /**
     * getById
     * @param id
     * @return
     */
    @GetMapping("/provider/{id}")
    String getById(@PathVariable("id") Long id);
}

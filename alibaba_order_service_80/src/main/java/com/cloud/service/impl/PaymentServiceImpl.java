package com.cloud.service.impl;

import com.cloud.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author
 * @date 2020/3/11
 */
@Slf4j
@Component
public class PaymentServiceImpl implements IPaymentService {
    @Override
    public String getById(Long id) {
        String result = "Sentinel + OpenFeign + Ribbon 服务降级";
        log.info(result);
        return result;
    }
}

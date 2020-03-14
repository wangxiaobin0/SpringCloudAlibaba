package com.cloud.controller;

import com.cloud.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author
 * @date 2020/3/9
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    private static final String SERVICE_NAME = "http://alibaba-nacos-payment-service";

    @Resource
    IPaymentService paymentService;
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Long id) {
//        String s = restTemplate.getForObject(SERVICE_NAME + "/provider/" + id, String.class);
        String s = paymentService.getById(id);
        return s;
    }
}

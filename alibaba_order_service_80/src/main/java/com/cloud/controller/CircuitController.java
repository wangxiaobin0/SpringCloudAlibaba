package com.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cloud.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author
 * @date 2020/3/11
 */
@Slf4j
@RestController
@RequestMapping("/circuit")
public class CircuitController {

    public static final String SERVICE_NAME = "http://alibaba-nacos-payment-service/provider/";

    @Autowired
    RestTemplate restTemplate;

    @Resource
    IPaymentService paymentService;

    /**
     * 服务异常时errorPage.
     * 服务熔断时errorPage.
     * @param id
     * @return
     * @throws IllegalAccessException
     */
    @GetMapping("/none")
    @SentinelResource(value = "resource")
    public String getByIdNone(Long id) throws IllegalAccessException{
        if (id > 4L) {
            throw new IllegalAccessException("查不到值");
        }
        String result = restTemplate.getForObject(SERVICE_NAME + id, String.class, id);
        log.info(result);
        return result;
    }


    /**
     * 服务异常时fallback
     * 服务熔断时fallback
     * @param id
     * @return
     * @throws IllegalAccessException
     */
    @GetMapping("/fallback")
    @SentinelResource(value = "resource", fallback = "fallback")
    public String getByIdFallback(Long id) throws IllegalAccessException{
        if (id > 4L) {
            throw new IllegalAccessException("查不到值");
        }
        String result = restTemplate.getForObject(SERVICE_NAME + id, String.class, id);
        log.info(result);
        return result;
    }

    /**
     * 服务异常时errorPage
     * 服务熔断时blockHandler
     * @param id
     * @return
     * @throws IllegalAccessException
     */
    @GetMapping("/blockHandler")
    @SentinelResource(value = "resource", blockHandler = "blockHandler")
    public String getByIdBlockHandler(Long id) throws IllegalAccessException{
        if (id > 4L) {
            throw new IllegalAccessException("查不到值");
        }
        String result = restTemplate.getForObject(SERVICE_NAME + id, String.class, id);
        log.info(result);
        return result;
    }

    /**
     * 服务异常时fallback
     * 服务熔断时blockHandler
     * 一开始异常fallback, 触发熔断后blockHandler
     * @param id
     * @return
     * @throws IllegalAccessException
     */
    @GetMapping("/all")
    @SentinelResource(value = "resource", blockHandler = "blockHandler", fallback = "fallback")
    public String getByIdAll(Long id) throws IllegalAccessException{
        if (id > 4L) {
            throw new IllegalAccessException("查不到值");
        }
        String result = restTemplate.getForObject(SERVICE_NAME + id, String.class, id);
        log.info(result);
        return result;
    }



    public String fallback(Long id, Throwable e) {
        String result = "fallback----服务降级-----" + e.getClass().getCanonicalName();
        log.info(result);
        return result;
    }

    public String blockHandler(Long id, BlockException e) {
        String result = "blockHandler----服务熔断-----" + e.getClass().getCanonicalName();
        log.info(result);
        return result;
    }

    @GetMapping("/feign")
    @SentinelResource(value = "feign", blockHandler = "blockHandler")
    public String openFeign(Long id) {
        String result = paymentService.getById(id);
        log.info(result);
        return result;
    }

}

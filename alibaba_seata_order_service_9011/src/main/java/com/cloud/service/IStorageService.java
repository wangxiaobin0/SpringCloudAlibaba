package com.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author
 * @date 2020/3/12
 */
@Component
@FeignClient(value = "alibaba-seata-storage-service")
public interface IStorageService {
    /**
     * 更新库存
     *
     * @param productId 产品编号
     * @param count 购买数量
     */
    @PostMapping("/storage")
    void updateStorage(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}

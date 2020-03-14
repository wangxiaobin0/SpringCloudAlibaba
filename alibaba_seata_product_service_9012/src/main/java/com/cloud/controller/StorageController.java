package com.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.cloud.domain.CommonResult;
import com.cloud.service.IStorageService;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * @date 2020/3/12
 */
@RestController
@Slf4j
public class StorageController {
    @Autowired
    IStorageService storageService;

    @PostMapping("/storage")
    @SentinelResource(value = "storage", fallback = "storageFallBack")
    public CommonResult updateStorage(@RequestParam("productId") Long productId, @RequestParam("count") Integer count) {
        storageService.updateStorage(productId, count);
        return new CommonResult("200", "库存更新成功");
    }

    public CommonResult storageFallBack(Long productId, Integer count) {
        log.info("更新库存失败");
        return new CommonResult("500", "更新库存失败");
    }

}

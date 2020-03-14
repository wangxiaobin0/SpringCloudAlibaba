package com.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author
 * @date 2020/3/11
 */
@FeignClient("alibaba-sentinel-service")
public interface ISentinelService {
    @GetMapping("/sentinel")
    String getInfo();

    @GetMapping("/sentinel/related")
    String testRelated();
}

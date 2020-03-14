package com.cloud.util;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author
 * @date 2020/3/13
 */
@Component
public class SnowFlakeUtil {
    private Long dataCenter = 1L;
    private Long workerId = 1l;
    Snowflake snowflake = IdUtil.createSnowflake(dataCenter, workerId);
    @PostConstruct
    public void init() {
        String localhostStr = NetUtil.getLocalhostStr();
        workerId = NetUtil.ipv4ToLong(localhostStr);
    }

    public Long snowFlake(Long dataCenter, Long workerId) {
        Snowflake snowflake = IdUtil.createSnowflake(dataCenter, workerId);
        return snowflake.nextId();
    }
    public Long snowFlake() {
        return snowflake.nextId();
    }

    public static void main(String[] args) {
        System.out.println(new SnowFlakeUtil().snowFlake());
    }
}

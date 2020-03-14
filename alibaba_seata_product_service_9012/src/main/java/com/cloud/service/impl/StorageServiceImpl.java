package com.cloud.service.impl;

import com.cloud.dao.IStorageDao;
import com.cloud.service.IStorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author
 * @date 2020/3/12
 */
@Slf4j
@Service
public class StorageServiceImpl implements IStorageService {
    @Resource
    IStorageDao storageDao;
    @Override
    public void updateStorage(Long productId, Integer count) {
        log.info("更新库存.\t产品编号:" + productId + "\t数量:" + count);
        storageDao.updateStorage(productId, count);
    }
}

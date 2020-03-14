package com.cloud.service;

/**
 * @author
 * @date 2020/3/12
 */
public interface IStorageService {
    /**
     * 更新库存
     * @param productId
     * @param count
     */
    void updateStorage(Long productId, Integer count);
}

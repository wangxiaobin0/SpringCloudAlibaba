package com.cloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author
 * @date 2020/3/12
 */
@Mapper
public interface IStorageDao {
    /**
     * 更新库存
     * @param productId
     * @param count
     */
    void updateStorage(@Param("productId") Long productId, @Param("count") Integer count);
}

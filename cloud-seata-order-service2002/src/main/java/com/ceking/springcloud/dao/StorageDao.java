package com.ceking.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author ceking
 * @desc
 * @date 2021/1/27 22:04
 */
@Mapper
public interface StorageDao {

    //扣减库存信息
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}

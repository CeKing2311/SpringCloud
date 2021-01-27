package com.ceking.springcloud.service;

/**
 * @author ceking
 * @desc
 * @date 2021/1/27 22:06
 */

public interface StorageService {
    // 扣减库存
    void decrease(Long productId, Integer count);
}

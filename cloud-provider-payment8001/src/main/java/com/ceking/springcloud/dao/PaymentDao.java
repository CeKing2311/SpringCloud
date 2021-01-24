package com.ceking.springcloud.dao;

import com.ceking.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author ceking
 * @desc
 * @date 2021/1/23 13:42
 */

@Mapper
public interface PaymentDao {
    public  int create(Payment payment);
    public  Payment getPaymentById(@Param("id") Long id);
}

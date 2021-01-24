package com.ceking.springcloud.service;

import com.ceking.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author ceking
 * @desc
 * @date 2021/1/23 13:57
 */

public interface PaymentService {
    public  int create(Payment payment);
    public  Payment getPaymentById(@Param("id") Long id);
}

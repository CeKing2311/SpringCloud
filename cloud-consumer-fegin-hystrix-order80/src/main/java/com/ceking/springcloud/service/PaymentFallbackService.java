package com.ceking.springcloud.service;

import org.springframework.stereotype.Component;

/*
 *@author ceking
 *@description
 *@date 2021-1-25 15:34
 */
@Component
public class PaymentFallbackService implements  PaymentService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentFallbackService fall back paymentInfo_OK,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentFallbackService fall back paymentInfo_TimeOut,o(╥﹏╥)o";
    }
}

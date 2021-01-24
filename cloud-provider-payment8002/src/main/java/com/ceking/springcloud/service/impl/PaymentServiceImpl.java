package com.ceking.springcloud.service.impl;

import com.ceking.springcloud.dao.PaymentDao;
import com.ceking.springcloud.entities.Payment;
import com.ceking.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ceking
 * @desc
 * @date 2021/1/23 13:57
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}

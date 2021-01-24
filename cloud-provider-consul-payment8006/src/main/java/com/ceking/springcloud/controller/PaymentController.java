package com.ceking.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author ceking
 * @desc
 * @date 2021/1/24 17:39
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private  String serverPort;

    @GetMapping(value = "/payment/consul")
    public String paymentConsul(){
        return  "spring cloud with consul"+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}

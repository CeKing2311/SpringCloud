package com.ceking.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author ceking
 * @desc
 * @date 2021/1/23 14:57
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    //@LoadBalanced //赋予RestTemplate负载均衡能力
    public RestTemplate getRestTemplate(){
        return  new RestTemplate();
    }

}

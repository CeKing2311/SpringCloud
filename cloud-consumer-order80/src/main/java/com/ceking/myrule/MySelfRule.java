package com.ceking.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ceking
 * @desc
 * @date 2021/1/24 18:14
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
        //定义为随机
        return  new RandomRule();
    }
}

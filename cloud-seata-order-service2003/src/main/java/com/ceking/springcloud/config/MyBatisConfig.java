package com.ceking.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author ceking
 * @desc
 * @date 2021/1/27 21:42
 */
@Configuration
@MapperScan({"com.ceking.springcloud.dao"})
public class MyBatisConfig {

}

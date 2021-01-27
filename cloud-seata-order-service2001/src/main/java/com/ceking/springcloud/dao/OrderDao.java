package com.ceking.springcloud.dao;

import com.ceking.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author ceking
 * @desc
 * @date 2021/1/27 21:19
 */
@Mapper
public interface OrderDao {
    //创建订单
    public  void  create(Order order);
    //修改订单
    public void  update(@Param("userId") Long userId,@Param("status") Integer status);

}


package com.ceking.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.security.PublicKey;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/*
 *@author ceking
 *@description Ribbon 自定义负载均衡算法
 *@date 2021-1-25 10:10
 */
@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next; //访问次数
        do {
            current = this.atomicInteger.get();
            next = current > 2147483647 ? 0 : current + 1;

        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("***********第几次访问，次数next:"+next);
        return  next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();

        return serviceInstances.get(index);
    }
}

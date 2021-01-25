package com.ceking.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/*
 *@author ceking
 *@description
 *@date 2021-1-25 10:08
 */
public interface LoadBalancer {

    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}

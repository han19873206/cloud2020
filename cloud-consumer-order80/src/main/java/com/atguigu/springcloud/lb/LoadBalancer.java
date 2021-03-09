package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author Hanwj
 * @Date 2021/3/9 17:14
 */
public interface LoadBalancer {

    ServiceInstance instance(List<ServiceInstance> serviceInstances);



}

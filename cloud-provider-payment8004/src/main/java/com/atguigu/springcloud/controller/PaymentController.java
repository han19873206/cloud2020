package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Hanwj
 * @Date 2021/3/8 10:45
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Resource//服务发现客户端,提供给其他用户以查看本服务的信息
    private DiscoveryClient discoveryClient;

    @GetMapping("/payment/discovery")
    public Object discovery() {
        //查询eureka上有哪些服务名
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info(service);
        }
        //服务名CLOUD-PAYMENT-SERVICE下有哪些实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }

        return this.discoveryClient;
    }

}

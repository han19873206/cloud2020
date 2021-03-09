package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Hanwj
 * @Date 2021/3/8 10:45
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource//服务发现客户端,提供给其他用户以查看本服务的信息
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "成功,serverPort:" + serverPort, result);
        }
        return new CommonResult(444, "失败,serverPort:" + serverPort, null);
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") String id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果11111：" + payment);
        int a = 1;
        if (payment != null) {
            return new CommonResult(200, "成功,serverPort:" + serverPort, payment);
        }
        return new CommonResult(444, "失败,serverPort:" + serverPort, null);
    }

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

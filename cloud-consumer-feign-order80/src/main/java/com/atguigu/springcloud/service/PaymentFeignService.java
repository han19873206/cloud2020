package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author Hanwj
 * @Date 2021/3/9 18:47
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")//引入微服务名称
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") String id);

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout();
}

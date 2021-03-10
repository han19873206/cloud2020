package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Hanwj
 * @Date 2021/3/10 9:58
 */
@RestController
@Slf4j
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;


    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String payment_OK(@PathVariable("id") Integer id) {
        String s = paymentHystrixService.payment_OK(id);
        log.info(s);
        return s;
    }


    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String payment_TimeOut(@PathVariable("id") Integer id) {
        String s = paymentHystrixService.payment_TimeOut(id);
        log.info(s);
        return s;
    }
}

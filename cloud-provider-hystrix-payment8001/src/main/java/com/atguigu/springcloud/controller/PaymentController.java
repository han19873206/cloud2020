package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Hanwj
 * @Date 2021/3/10 9:17
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @GetMapping("payment/hystrix/ok/{id}")
    public String payment_OK(@PathVariable("id") Integer id) {
        String s = paymentService.paymentInfo_OK(id);
        log.info("结果：" + s);
        return s;
    }

    @GetMapping("payment/hystrix/timeout/{id}")
    public String payment_TimeOut(@PathVariable("id") Integer id) {
        String s = paymentService.paymentInfo_TimeOut(id);
        log.info("结果：" + s);
        return s;
    }
}

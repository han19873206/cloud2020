package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
    public CommonResult create(@PathVariable("id") String id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果11111：" + payment);
        int a = 1;
        if (payment != null) {
            return new CommonResult(200, "成功,serverPort:" + serverPort, payment);
        }
        return new CommonResult(444, "失败,serverPort:" + serverPort, null);
    }
}

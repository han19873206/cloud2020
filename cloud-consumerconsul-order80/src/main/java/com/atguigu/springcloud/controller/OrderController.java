package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author Hanwj
 * @Date 2021/3/8 18:27
 */
@RestController//@ResponseBody和@Controller合体
@Slf4j//日志
public class OrderController {
    public static final String PAYMENT_URL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String paymentInfo() {
        log.info("++++++++++++++++++++++++++++");
        return restTemplate.getForObject(PAYMENT_URL + "/payment/consul", String.class);
    }

}

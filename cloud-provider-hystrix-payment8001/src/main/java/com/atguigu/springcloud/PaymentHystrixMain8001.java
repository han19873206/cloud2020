package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @Author Hanwj
 * @Date 2021/3/10 9:10
 */
@SpringBootApplication
@EnableEurekaClient//开启注册服务
//@EnableHystrix
@EnableCircuitBreaker//开启服务降级，与@EnableHystrix一样，本质相同
public class PaymentHystrixMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8001.class, args);
    }
}

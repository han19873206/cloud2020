package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author Hanwj
 * @Date 2021/3/10 9:13
 */
@Service
public class PaymentService {

    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + " OK,id:\t" + id;
    }

    /**
     * 注意：@HystrixCommand与@EnableHystrix 本质是同一个注解，都是启动服务降级的注解
     * Hystrix服务熔断降级时，是用新的线程池来处理。
     * 超时参数：@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        int timeNumber = 5;
        //int i = 10 / 0;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + " TimeOut,id:\t" + id + " 耗时" + timeNumber + "秒！";
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + " fallback 服务降级";
    }
}

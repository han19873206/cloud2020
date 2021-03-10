package com.atguigu.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author Hanwj
 * @Date 2021/3/10 9:13
 */
@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id){
        return "线程池："+Thread.currentThread().getName()+" OK,id:\t"+id;
    }

    public String paymentInfo_TimeOut(Integer id){
        int timeNumber=5;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+" TimeOut,id:\t"+id+" 耗时"+timeNumber+"秒！";
    }

}

package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;

/**
 * @Author Hanwj
 * @Date 2021/3/8 10:42
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(String id);
}

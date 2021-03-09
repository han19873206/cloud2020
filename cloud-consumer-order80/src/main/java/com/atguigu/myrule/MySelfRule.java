package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Hanwj
 * @Date 2021/3/9 16:41
 *
 * 注意：自定义负载方式时，不能放在main方法同路径下
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {
        //随机
        return new RandomRule();
    }
}

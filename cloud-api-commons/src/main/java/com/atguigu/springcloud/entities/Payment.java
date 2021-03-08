package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author Hanwj
 * @Date 2021/3/8 10:10
 */
//这些都是lombok的注解
@Data//解决get,set,toString,equals
@AllArgsConstructor//全参构造函数
@NoArgsConstructor//无参构造函数
public class Payment implements Serializable {
    private String id;
    private String serial;
}

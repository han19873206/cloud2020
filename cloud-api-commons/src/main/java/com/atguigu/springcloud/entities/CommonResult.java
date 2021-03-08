package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Hanwj
 * @Date 2021/3/8 10:26
 */
//这些都是lombok的注解
@Data//解决get,set,toString,equals
@AllArgsConstructor//全参构造函数
@NoArgsConstructor//无参构造函数
public class CommonResult<T> {

    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}

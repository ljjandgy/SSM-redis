package com.example.springredis.ioc.autowire;

import org.springframework.stereotype.Component;

/**
 * @author ljj
 * @version sprint 21
 * @className Bean2
 * @description
 * @date 2020-06-09 14:49:31
 */
@Component
public class Bean2 implements BeanInterface {
    @Override
    public void getName() {
        System.out.println("bean2");
    }
}

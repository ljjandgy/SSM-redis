package com.example.springredis.ioc.autowire;

import org.springframework.stereotype.Component;

/**
 * @author ljj
 * @version sprint 21
 * @className Bean1
 * @description
 * @date 2020-06-09 14:47:41
 */
@Component
public class Bean1 implements  BeanInterface{
    @Override
    public void getName() {
        System.out.println("bean1");
    }
}

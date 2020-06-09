package com.example.springredis.ioc.beanfactory;

import org.springframework.stereotype.Component;

/**
 * @author ljj
 * @version sprint 21
 * @className TestBean
 * @description
 * @date 2020-06-09 11:04:48
 */
@Component
public class TestBean {
    public void test(){
        System.out.println("just test");
    }
}

package com.example.springredis.ioc.autowire;

import org.springframework.stereotype.Component;

/**
 * @author ljj
 * @version sprint 21
 * @className BeanTest
 * @description
 * @date 2020-06-09 15:23:28
 */
@Component
public class BeanTest {
    private BeanInterface beanInterface;
    //构造方法注入时，是在构造方法的参数上进行操作，和属性名称无关
    public BeanTest(BeanInterface bean1){
        this.beanInterface = bean1;
    }

    public void test(){
        beanInterface.getName();
    }
}

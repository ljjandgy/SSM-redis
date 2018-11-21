package com.example.springredis.reflect;

/**
 * 被代理对象实现类
 */
public class ProxyTestImpl implements ProxyInterface {
    @Override
    public void sayHello() {
        System.out.println("说你好！");
    }
}

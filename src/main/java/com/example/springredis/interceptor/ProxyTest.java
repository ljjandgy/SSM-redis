package com.example.springredis.interceptor;

public class ProxyTest implements IProxyTest {
    @Override
    public void sayHello() {
        System.out.print("说你好！");
    }
}

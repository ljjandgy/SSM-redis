package com.example.springredis.reflect;

public class ReflectTest {
    public static void main(String[] arg){
        JdkProxyExample jdkProxyExample = new JdkProxyExample();
        //建立连接，返回代理对象
        ProxyInterface proxy = (ProxyInterface)jdkProxyExample.bind(new ProxyTestImpl());
        //调用代理逻辑
        proxy.sayHello();
    }
}

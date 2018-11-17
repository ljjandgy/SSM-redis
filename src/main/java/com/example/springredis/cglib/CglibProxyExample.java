package com.example.springredis.cglib;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLIB代理类
 */
public class CglibProxyExample implements MethodInterceptor {
    /**
     * 生成代理对象
     * @param cla 被代理的类
     * @return 代理对象
     */
    public Object bind(Class cla){
        //获取CGLIB增强类对象
        Enhancer enhancer = new Enhancer();
        //设置对哪个类进行增强
        enhancer.setSuperclass(cla);
        //设置哪个类为代理类，代理类必须实现MethodInterceptor接口
        enhancer.setCallback(this);
        //生成代理对象并返回(根据之前的设置来生成代理对象)
        return enhancer.create();
    }
    /**
     * 代理类逻辑方法
     * @param proxy 被代理对象
     * @param method 代理类执行的方法对象
     * @param args 方法传参
     * @param methodProxy 方法代理对象
     * @return 方法执行结果
     * @throws Throwable
     */
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始执行代理类逻辑");
        System.out.println("执行完代理类逻辑，准备执行真实对象方法");
        //调用真实对象的方法
        Object result = methodProxy.invokeSuper(proxy,args);
        System.out.println("真实对象方法执行完毕");
        return null;
    }
}

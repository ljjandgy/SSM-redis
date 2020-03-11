package com.example.springredis.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class JavaMethodAreaOomTest {
    static class OomTest{

    }
    public static void main(String[] args) {
        while (true){
            //通过CGLIB创建类
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OomTest.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(objects,args);
                }
            });
            enhancer.create();
        }
    }
}

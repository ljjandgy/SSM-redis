package com.example.springredis.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyExample implements InvocationHandler {
    private Object target;//被代理的类对象

    public Object bind(Object target){
        this.target = target;
        //根据传入的对象（被代理对象）生成代理对象，newProxyInstance方法的三个参数分别为（被代理类的类加载器，被代理类的接口类型，InvocationHandler类型的对象）
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    /**
     * 代理逻辑的实现方法
     * @param proxy 代理对象
     * @param method 被代理的方法对象，类似于切面中被通知的方法
     * @param args 被代理方法传参
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("现在已经进入代理方法");
        System.out.println("先走一波代理逻辑，走完调用被代理对象的方法");
        //invoke方法传入了对象的引用已经方法的参数，具体调用哪个方法由method对象自己记录（自己知道自己是谁）
        Object object = method.invoke(target,args);
        System.out.println("成功完成被代理对象方法的调用");
        return object;
    }
}

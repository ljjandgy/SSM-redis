package com.example.springredis.responsibility;

import com.example.springredis.interceptor.Interceptor;

import java.lang.reflect.Method;

/**
 * 二号拦截器
 */
public class ResponsibilityInterceptor2 implements Interceptor {
    /**
     * 作用于真实对象之前的方法
     * @param proxy 代理对象
     * @param target 真实对象（被代理对象）
     * @param method 方法对象
     * @param args 方法参数
     * @return 是否反射真实方法（true反射）
     */
    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.out.print("我是二号拦截器的before");
        return true;
    }
    /**
     * 用于代理真实对象的方法（before返回false时触发）
     * @param proxy 代理对象
     * @param target 真实对象（被代理对象）
     * @param method 方法对象
     * @param args 方法参数
     */
    @Override
    public void around(Object proxy, Object target, Method method, Object[] args) {
        System.out.print("我是二号拦截器的around");
    }
    /**
     * 作用于真实对象方法之后的方法
     * @param proxy 代理对象
     * @param target 真实对象（被代理对象）
     * @param method 方法对象
     * @param args 方法参数
     */
    @Override
    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.out.print("我是二号拦截器的after");
    }
}

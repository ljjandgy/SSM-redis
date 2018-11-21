package com.example.springredis.interceptor;

import java.lang.reflect.Method;

/**
 * 拦截器接口（jdk动态代理实现拦截器）
 */
public interface Interceptor {
    //作用于被代理对象方法执行之前，如果该方法返回true，则调用被代理对象方法，否则直接走around方法（）
    public boolean before(Object proxy,Object target,Method method, Object[] args);
    //用于代替被代理对象方法
    public void around(Object proxy,Object target,Method method, Object[] args);
    //被代理对象方法或around方法执行后调用的方法
    public void after(Object proxy,Object target,Method method, Object[] args);
}

package com.example.springredis.interceptor;

import java.lang.reflect.Method;

/**
 * 拦截器实现类
 */
public class MyInterceptor implements Interceptor{
    /**
     * 在真实对象方法执行之前执行的逻辑
     * @param proxy 代理对象
     * @param target 真实对象
     * @param method 代理对象执行的方法对象
     * @param args 方法传参
     * @return 是否反射真实对象（true反射真实对象方法，false就不反射了）
     */
    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        return false;
    }
    /**
     * 代替真实对象方法的逻辑方法
     * @param proxy 代理对象
     * @param target 真实对象
     * @param method 代理对象执行的方法对象
     * @param args 方法传参
     */
    @Override
    public void around(Object proxy, Object target, Method method, Object[] args) {

    }
    /**
     * 执行完around()或者是真实对象方法之后执行的逻辑
     * @param proxy 代理对象
     * @param target 真实对象
     * @param method 代理对象执行的方法对象
     * @param args 方法传参
     */
    @Override
    public void after(Object proxy, Object target, Method method, Object[] args) {

    }
}

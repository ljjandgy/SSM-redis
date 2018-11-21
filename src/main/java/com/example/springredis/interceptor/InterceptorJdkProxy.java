package com.example.springredis.interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理类
 */
public class InterceptorJdkProxy implements InvocationHandler {
    private Object target = null;//真实对象
    private String interceptorClass = "";//拦截器全限定名

    public InterceptorJdkProxy(Object target,String interceptorClass){
        this.target = target;
        this.interceptorClass = interceptorClass;
    }

    /**
     * 让代理类和真实对象建立关系，并且返回代理对象
     * @param target 真实对象
     * @param interceptorClass 拦截器全限定名
     * @return
     */
    public static Object bind(Object target,String interceptorClass){
        //newProxyInstance三个参数分别为：真实对象的类加载器，真实对象集成的所有接口类型，实现代理类逻辑的对象（对象必须实现InvocationHandler接口）
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),new InterceptorJdkProxy(target,interceptorClass));
    }
    /**
     * 代理类实现逻辑，在代理类执行方法时，首先会进入该方法
     * @param proxy 代理类对象
     * @param method 方法对象
     * @param args 方法传承
     * @return 方法返回对象
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;//返回结果对象
        //没有设置拦截器时，就直接反射方法
        if(interceptorClass==null){
            result = method.invoke(target,args);//通过反射调用真实对象方法
        }
        Interceptor interceptor = (Interceptor)Class.forName(interceptorClass).newInstance();//通过反射获取接口实例
        if (interceptor.before(proxy,target,method,args)){
            result = method.invoke(target,args);//通过反射调用真实对象方法
        }else{
            interceptor.around(proxy,target,method,args);
        }
        interceptor.after(proxy,target,method,args);
        return result;
    }
}

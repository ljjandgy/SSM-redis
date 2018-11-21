package com.example.springredis;

import com.example.springredis.cglib.CglibTest;
import com.example.springredis.interceptor.InterceptorJdkProxy;
import com.example.springredis.reflect.ProxyInterface;
import com.example.springredis.reflect.ProxyTestImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 拦截器测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class InterceptorTest {
    @Test
    public void test(){
        //获取代理对象，参数分别为真实对象（被代理对象），拦截器实现类全限定名
        ProxyInterface proxy = (ProxyInterface)InterceptorJdkProxy.bind(new ProxyTestImpl(),"com.example.springredis.interceptor.MyInterceptor");
        proxy.sayHello();//由代理类执行真实对象方法
    }
}

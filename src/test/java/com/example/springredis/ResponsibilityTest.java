package com.example.springredis;

import com.example.springredis.interceptor.IProxyTest;
import com.example.springredis.interceptor.Interceptor;
import com.example.springredis.interceptor.InterceptorJdkProxy;
import com.example.springredis.interceptor.ProxyTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResponsibilityTest {
    /**
     * 利用之前撸好的代理类进行多个拦截器的代理
     */
    @Test
    public void responsibilityTest(){
        IProxyTest interceptor1 = (IProxyTest)InterceptorJdkProxy.bind(new ProxyTest(),"com.example.springredis.responsibility.ResponsibilityInterceptor1");
        IProxyTest interceptor2 = (IProxyTest)InterceptorJdkProxy.bind(interceptor1,"com.example.springredis.responsibility.ResponsibilityInterceptor2");
        IProxyTest interceptor3 = (IProxyTest)InterceptorJdkProxy.bind(interceptor2,"com.example.springredis.responsibility.ResponsibilityInterceptor3");
        interceptor3.sayHello();
    }
}

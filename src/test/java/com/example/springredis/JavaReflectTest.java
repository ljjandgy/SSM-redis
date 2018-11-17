package com.example.springredis;

import com.example.springredis.cglib.CglibProxyExample;
import com.example.springredis.cglib.CglibTest;
import com.example.springredis.domain.ShopDomain;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Method;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaReflectTest {
    @Test
    public void cglibTest(){
        try{
            //创建代理类对象
            CglibProxyExample cglibProxyExample = new CglibProxyExample();
            //通过代理类获取CglibTest类的代理对象
            CglibTest cglibTest =(CglibTest)cglibProxyExample.bind(CglibTest.class);//绑定管理，确定代理哪个类
            //由代理类执行真实对象方法
            cglibTest.justSayHello();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

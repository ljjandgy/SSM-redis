package com.example.springredis;

import com.example.springredis.builder.Builder;
import com.example.springredis.builder.Director;
import com.example.springredis.builder.IBuilder;
import com.example.springredis.builder.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 程序开发者使用的类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BuilderTest {
    @Test
    public void test(){
        Director director = new Director();//实例化导演类
        IBuilder builder = new Builder();
        Product product = director.getProductA(builder);//构建实例
        System.out.println(product.getPro1());
    }
}

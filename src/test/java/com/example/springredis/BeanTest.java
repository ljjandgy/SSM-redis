package com.example.springredis;

import com.example.springredis.ioc.autowire.BeanInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ljj
 * @version sprint 21
 * @className BeanTest
 * @description
 * @date 2020-06-09 14:52:39
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BeanTest {
    /**
     * 显示通过byName设置进行操作，如果byName没有匹配到bean，再通过byType进行匹配
     */
    @Autowired
    BeanInterface bean1;

    @Test
    public void test(){
        bean1.getName();
    }
}

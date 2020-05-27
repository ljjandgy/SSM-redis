package com.example.springredis;

import com.example.springredis.factorybean.CustomBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ljj
 * @version sprint 21
 * @className FactoryBeanTest
 * @description
 * @date 2020-05-27 15:04:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FactoryBeanTest {
    @Autowired
    CustomBean customBean;
    @Autowired
    ApplicationContext context;

    @Test
    public void test(){
        //通过测试可以发现，factoryBean产生的Bean是没有在容器中保存的，并且当我们获取从容器中根据factoryBean的名称获取到的是factoryBean的getObject()方法返回的对象
        //而想要获取factoryBean本身的话，需要在名称前加上&符
        System.out.println(customBean.getName());
        System.out.println(context.getBean("getNewBean"));
        System.out.println(context.getBean("&getNewBean"));
        System.out.println(context.getBean("customBean"));
    }


}

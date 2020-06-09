package com.example.springredis.ioc.beanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Service;

/**
 * @author ljj
 * @version sprint 21
 * @className BeanFactoryAnnotationTest
 * @description
 * @date 2020-06-09 11:05:51
 */
@Service
public class BeanFactoryAnnotationTest {
    @Autowired
    static DefaultListableBeanFactory beanFactory;

    public static void main(String[] args) {
        TestBean testBean = (TestBean)beanFactory.getBean("testBean");
        testBean.test();
    }
}

package com.example.springredis.ioc.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * @author ljj
 * @version sprint 23
 * @className BeanFactoryAwareDemo
 * @description 用于获取BeanFactory
 * @date 2020-06-23 16:48:43
 */
public class BeanFactoryAwareDemo implements BeanFactoryAware {
    private  BeanFactory beanFactory1;
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory1 = beanFactory;
    }

    public void test(){
        beanFactory1.getBean("testBean");
    }
}

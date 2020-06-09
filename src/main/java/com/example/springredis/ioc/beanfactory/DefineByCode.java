package com.example.springredis.ioc.beanfactory;

import com.example.springredis.ioc.before.DowJonesNewsListener;
import com.example.springredis.ioc.before.DowJonesNewsPersister;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @author ljj
 * @version sprint 21
 * @className DefineByCode
 * @description 手动初始化BeanFactory容器
 * @date 2020-06-08 11:55:54
 */
public class DefineByCode {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
        BeanFactory container = bindViaCode(beanRegistry);
        FXNewsProvider provider = (FXNewsProvider)container.getBean("newsProvider");
        provider.getAndPersistNews();
    }

    public static BeanFactory bindViaCode(BeanDefinitionRegistry registry){
        //初始化bean
        AbstractBeanDefinition newsProvider = new RootBeanDefinition(FXNewsProvider.class);
        AbstractBeanDefinition newsListener = new RootBeanDefinition(DowJonesNewsListener.class);
        AbstractBeanDefinition newsPersister = new RootBeanDefinition(DowJonesNewsPersister.class);
        //把bean放到容器中
        registry.registerBeanDefinition("newsProvider",newsProvider);
        registry.registerBeanDefinition("newsListener",newsListener);
        registry.registerBeanDefinition("newsPersister",newsPersister);
        //依赖注入，这里正常情况下是从容器中获取bean后注入到相应类中
        ConstructorArgumentValues constructorArgumentValues = new ConstructorArgumentValues();
        constructorArgumentValues.addIndexedArgumentValue(0,newsListener);
        constructorArgumentValues.addIndexedArgumentValue(1,newsPersister);
        //通过构造方法注入
        newsProvider.setConstructorArgumentValues(constructorArgumentValues);
        //容器初始化完成，返回容器
        return (BeanFactory)registry;
    }
}

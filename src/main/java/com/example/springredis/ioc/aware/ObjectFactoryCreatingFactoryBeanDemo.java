package com.example.springredis.ioc.aware;

import org.springframework.beans.factory.config.ObjectFactoryCreatingFactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author ljj
 * @version sprint 23
 * @className ObjectFactoryCreatingFactoryBeanDemo
 * @description 用于获取bean，父类会自动注入beanFactory，用于隔离BeanFactory
 * @date 2020-06-23 17:18:30
 */
@Component
public class ObjectFactoryCreatingFactoryBeanDemo extends ObjectFactoryCreatingFactoryBean{
   public Object getBean(String beanName) throws Exception{
       setTargetBeanName(beanName);
       return getObject();
   }
}

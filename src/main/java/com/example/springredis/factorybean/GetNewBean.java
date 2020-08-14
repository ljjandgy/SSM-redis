package com.example.springredis.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author ljj
 * @version sprint 21
 * @className GetNewBean
 * @description
 * @date 2020-05-27 11:58:28
 */
@Component
public class GetNewBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return new CustomBean("newTest");
    }

    @Override
    public Class<?> getObjectType() {
        return CustomBean.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}

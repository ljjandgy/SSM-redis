package com.example.springredis.mybatis;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.TypeAliasRegistry;
import org.apache.ibatis.type.TypeHandler;
import org.springframework.beans.factory.InitializingBean;

import java.util.Map;

/**
 * 别名配置类
 */
public class Alias implements InitializingBean {
    /**
     * spring在加载完所有bean后就会调用这个类
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        Configuration configuration = new Configuration();
        TypeAliasRegistry typeAliasRegistry = configuration.getTypeAliasRegistry();//获取mybatis别名对象
        typeAliasRegistry.registerAlias("1", Map.class);//自定义别名
    }
}

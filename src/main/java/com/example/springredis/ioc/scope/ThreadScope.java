package com.example.springredis.ioc.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ljj
 * @version sprint 21
 * @className ThreadScope
 * @description bean的作用范围为当前线程内
 * @date 2020-06-09 17:09:32
 */
public class ThreadScope implements Scope {
    /**
     * 自定义一个scope就需要定义scope对应的bean如何管理。
     * 比如当前这个Thread级别的Scope，就是直接把bean放到线程的本地变量表中去，其生命周期和线程一致。
     * 补充：
     * 1.spring Ioc直接存储的其实是singleton scope的Bean
     * 2.定义完scope后需要使用ConfigurableBeanFactory提供的registerScope方法把自定义的scope放到容器中去才能使用
     *
     */
    private final ThreadLocal threadScope = new ThreadLocal(){
        @Override
        protected Object initialValue() {
            return new HashMap();
        }
    };
    @Override
    public Object get(String s, ObjectFactory<?> objectFactory) {
        Map scope = (Map) threadScope.get();
        Object bean = scope.get(s);
        if (bean==null){
            bean = objectFactory.getObject();
            //把创建的bean放入本地变量表中
            scope.put(s,bean);
        }
        return bean;
    }

    @Override
    public Object remove(String s) {
        Map scope = (Map) threadScope.get();
        return scope.remove(s);
    }

    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {

    }

    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}

package com.example.springredis.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * redisHyperLogLog操作
 */
@Component
public class HyperLogLog {
    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 添加内容
     */
    public void addLogInfo(){
        for (int i=0;i<10000;i++){
            redisTemplate.opsForHyperLogLog().add("page1","user"+i);
        }
        for (int i=0;i<10000;i++){
            redisTemplate.opsForHyperLogLog().add("page2","user"+i);
        }
        for (int i=0;i<10000;i++){
            redisTemplate.opsForHyperLogLog().add("page3","users"+i);
        }
    }

    /**
     * 获取数量
     * @return
     */
    public long getCount(){
        return redisTemplate.opsForHyperLogLog().size("page1");
    }

    /**
     * 合并多个分组，获取数量
     */
    public long getUnionCount(String key1,String key2){
        return redisTemplate.opsForHyperLogLog().union(key1,key2);
    }
}

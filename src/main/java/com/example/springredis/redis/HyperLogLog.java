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
    }

    /**
     * 获取数量
     * @return
     */
    public long getCount(){
        return redisTemplate.opsForHyperLogLog().size("page1");
    }
}

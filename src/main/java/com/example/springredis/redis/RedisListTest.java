package com.example.springredis.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

public class RedisListTest {
    @Autowired
    RedisTemplate redisTemplate;
    public void test(){
        //list是一个双向队列，只能从两头操作值
        //从最左边取值,key是list的key
        redisTemplate.opsForList().leftPop("key");
        //从左边放值,keyw为list的key，value为塞进去的值
        redisTemplate.opsForList().leftPush("key","value");
        redisTemplate.opsForValue().set("key","value");
        redisTemplate.opsForValue().get("key");
        redisTemplate.expire("key",0, TimeUnit.SECONDS);
    }
}

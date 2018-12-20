package com.example.springredis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisZsetOperateTest {
    @Autowired
    RedisTemplate redisTemplate;
    @Test
    public void test(){
        for (int i=0;i<10;i++){
            redisTemplate.opsForZSet().add("zsetTest","test"+i,i);
        }
        //根据score删除范围内的成员
        redisTemplate.opsForZSet().removeRangeByScore("zsetTest",0,5);
    }

}

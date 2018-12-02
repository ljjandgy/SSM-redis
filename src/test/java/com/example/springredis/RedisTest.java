package com.example.springredis;

import com.alibaba.fastjson.JSONObject;
import com.example.springredis.redis.RedisTestBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    RedisTemplate redisTemplate;
    @Test
    public void test(){
        RedisTestBean redisTestBean = new RedisTestBean();
        redisTestBean.setAddr("jinnan");
        redisTestBean.setName("ddddd");
        redisTestBean.setParam("aaaaa");
        redisTestBean.setParam1("rrrrrr");
        redisTemplate.opsForValue().set("key",redisTestBean);
        RedisTestBean redisTestBean1 = JSONObject.parseObject(redisTemplate.opsForValue().get("key").toString(),RedisTestBean.class);
        System.out.println(redisTestBean1.getAddr());
    }
}

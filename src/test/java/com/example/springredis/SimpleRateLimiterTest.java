package com.example.springredis;

import com.example.springredis.redis.SimpleRateLimiter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleRateLimiterTest {
    @Autowired
    SimpleRateLimiter simpleRateLimiter;
    @Test
    public void test(){
        //60之内只能操作5次
        boolean flag = simpleRateLimiter.isActionAllowed("xiaoxaiolll","reply",60,5);
        System.out.println(flag);
        flag = simpleRateLimiter.isActionAllowed("xiaoxaiolll","reply",60,5);
        System.out.println(flag);
        flag = simpleRateLimiter.isActionAllowed("xiaoxaiolll","reply",60,5);
        System.out.println(flag);
        flag = simpleRateLimiter.isActionAllowed("xiaoxaiolll","reply",60,5);
        System.out.println(flag);
        flag = simpleRateLimiter.isActionAllowed("xiaoxaiolll","reply",60,5);
        System.out.println(flag);
        flag = simpleRateLimiter.isActionAllowed("xiaoxaiolll","reply",60,5);
        System.out.println(flag);
        flag = simpleRateLimiter.isActionAllowed("xiaoxaiolll","reply",60,5);
        System.out.println(flag);

    }
}

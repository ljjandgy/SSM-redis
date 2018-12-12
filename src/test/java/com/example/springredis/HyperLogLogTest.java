package com.example.springredis;

import com.example.springredis.redis.HyperLogLog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HyperLogLogTest {
    @Autowired
    HyperLogLog logLogTest;
    @Test
    public void test(){
        logLogTest.addLogInfo();
        System.out.println(logLogTest.getCount());
    }
}

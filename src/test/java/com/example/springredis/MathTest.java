package com.example.springredis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MathTest {
    @Test
    public void test(){
        int x = 121;
        int xbak = x;
        //处理负数
        if(x<0){
            System.out.println("no");
        }
        int rec = 0;
        while(x!=0){
            int pop = x%10;//取最后一位
            x = x/10;
            rec = rec*10+pop;
        }
        if(rec==xbak){
            System.out.println("yes");
        }
        System.out.println("no");
    }
}

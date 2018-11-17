package com.example.springredis;

import com.example.springredis.domain.ShopDomain;
import com.example.springredis.service.IShopService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.UUID;

import static java.lang.System.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringRedisApplicationTests {
    @Autowired
    //用于指明装配接口的哪个实现类
    @Qualifier("ShopService")
    IShopService iShopService;

    @Test
    public void contextLoads() {
    }
    @Before
    public void beforeTest(){
        out.println("开始测试！");
    }

}

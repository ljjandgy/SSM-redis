package com.example.springredis.powermock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.System.out;

/**
 * @author ljj
 * @version V2.0
 * @className MockClass1
 * @description
 * @date 2020-03-06 10:12:30
 */
@Component
public class MockClass1 {
    @Autowired
    MockClass2 mockClass2;

    public void mockTest1(){
        out.println("调用公共方法成功");
        out.println(mockPrivate1());
        mockClass2.method1();
        out.println(MockClass2.staticMethod1());
    }

    private String mockPrivate1(){
        out.println("调用私有方法成功");
        return "succ";
    }
}

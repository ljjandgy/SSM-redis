package com.example.springredis.powermock;

import org.springframework.stereotype.Component;

/**
 * @author ljj
 * @version V2.0
 * @className MockClass2
 * @description
 * @date 2020-03-06 10:12:42
 */
@Component
public class MockClass2 {
    public void method1(){
        System.out.println("调用class2method1成功");
    }

    public static String staticMethod1(){
        System.out.println("调用class2staticMethod1成功");
        return "succ";
    }

}

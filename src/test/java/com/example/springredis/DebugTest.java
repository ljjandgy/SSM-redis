package com.example.springredis;

import com.example.springredis.debug.TestNew;
import org.junit.Test;

/**
 * @author ljj
 * @version V2.0
 * @className DebugTest
 * @description
 * @date 2020-02-25 11:33:09
 */
public class DebugTest {
    private TestNew testNew = new TestNew();
    @Test
    public void commonDebugTest(){

    }
    @Test
    public void exceptionDebugTest(){

    }
    @Test
    public void conditionDebugTest(){
        testNew.test(1);
    }
    @Test
    public void streamTest(){
        testNew.test(3);
    }

}

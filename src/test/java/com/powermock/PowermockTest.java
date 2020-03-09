package com.powermock;

import com.example.springredis.powermock.MockClass1;
import com.example.springredis.powermock.MockClass2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @author ljj
 * @version V2.0
 * @className PowermockTest
 * @description
 * @date 2020-03-06 10:10:28
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({MockClass1.class, MockClass2.class})
public class PowermockTest {
    @InjectMocks
    private MockClass1 mockClass1;
    @Mock
    private MockClass2 mockClass2;

    @Test
    public void mockPrivateTest() throws Exception{
        MockClass1 spy = PowerMockito.spy(mockClass1);
        PowerMockito.when(spy, "mockPrivate1").thenReturn("fail");
        spy.mockTest1();
        Assert.assertTrue(true);
    }
    @Test
    public void mockStaticTest(){
        PowerMockito.mockStatic(MockClass2.class);
        PowerMockito.when(MockClass2.staticMethod1()).thenReturn("fail");
        mockClass1.mockTest1();
        Assert.assertTrue(true);
    }
}

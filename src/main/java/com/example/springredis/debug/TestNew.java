package com.example.springredis.debug;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ljj
 * @version V2.0
 * @className Test
 * @description
 * @date 2020-02-25 17:57:21
 */
public class TestNew {
    public static void test(){
        int a = 1;
        int b= 2;
        String test1 = "test1";
        Boolean flag = Boolean.FALSE;
        List<DebugBo> debugBoList = Arrays.asList(new DebugBo("a","a"),new DebugBo("b","b"),new DebugBo("c","c"));
        List<String> strList = debugBoList.stream().map(DebugBo::getName).collect(Collectors.toList());
    }
}

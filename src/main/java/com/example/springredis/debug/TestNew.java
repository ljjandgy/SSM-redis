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
    public void test(int c){
        int a = 1;
        int b= 2;
        String test1 = "test1";
        Boolean flag = Boolean.FALSE;
        List<DebugBo> debugBoList = Arrays.asList(new DebugBo("a","a"),new DebugBo("b","b"),new DebugBo("c","c"));
        if ("aaa".equals(debugBoList.get(0).getName())){
            System.out.println("进入条件:"+debugBoList.get(0).getName());
        }
        if (add()>10){
            System.out.println("1111");
        }
        assembleDebugBo(new DebugBo());
        List<String> strList = debugBoList.stream().map(DebugBo::getName).collect(Collectors.toList());
        debugBoList.get(0).setName("111");
    }

    private void assembleDebugBo(DebugBo debugBo){
        debugBo.setName("name");
        debugBo.setDescription("description");
    }

    private int add(){
        return 12+13;
    }
}

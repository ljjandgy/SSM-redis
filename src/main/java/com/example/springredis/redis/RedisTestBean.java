package com.example.springredis.redis;

import java.io.Serializable;

/**
 * redis存储测试实体
 */
public class RedisTestBean implements Serializable {
    private String name;
    private String addr;
    private String param;
    private String param1;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }
}

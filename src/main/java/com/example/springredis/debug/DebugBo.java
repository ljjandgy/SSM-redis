package com.example.springredis.debug;

/**
 * @author ljj
 * @version V2.0
 * @className DebugBo
 * @description
 * @date 2020-02-25 18:03:50
 */
public class DebugBo {
    private String name;

    private String description;

    DebugBo(String name,String description){
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

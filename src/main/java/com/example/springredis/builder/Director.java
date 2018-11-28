package com.example.springredis.builder;

/**
 * 导演类
 */
public class Director {
    /**
     * 获取某个类型的产品
     * @param builder 建造者对象
     * @return
     */
    public Product getProductA(IBuilder builder){
        builder.setPro("1","1","1");
        return builder.getProduct();
    }
}

package com.example.springredis.builder;

/**
 * 抽象建造者类
 */
public interface IBuilder {
    void setPro(String pro1,String pro2,String pro3);
    Product getProduct();
}

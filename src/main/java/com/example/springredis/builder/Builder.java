package com.example.springredis.builder;

/**
 * 建造者类(建造)
 */
public class Builder implements IBuilder{
    private Product product;

    /**
     * 添加产品类属性
     * @param pro1
     * @param pro2
     * @param pro3
     */
    public void setPro(String pro1,String pro2,String pro3){
        product = new Product();
        product.setPro1(pro1);
    }
    public Product getProduct(){
        return product;
    }
}

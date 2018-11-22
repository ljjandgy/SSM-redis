package com.example.springredis.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * 产品列表（被观察者）
 */
public class ProductList extends Observable {
    private List<String> productList = null;
    private static ProductList instance;

    /**
     * 构造方法私有化，不允许外部类实例化本类和方法getInstance()一起构成了单例模式
     */
    private ProductList(){ }

    public static ProductList getInstance() {
        //单例为空时初始化实例
        if (instance==null){
            instance = new ProductList();//获取单例
            instance.productList = new ArrayList<String>();//初始化单例下的列表
        }
        return instance;
    }

    /**
     * 添加观察者（电商接口）
     * @param observer 观察者
     */
    public void addProductListObserver(Observer observer){
        this.addObserver(observer);
    }

    /**
     * 添加商品（改变被观察者）
     * @param productName 商品名称
     */
    public void addProduct(String productName){
        productList.add(productName);//添加商品
        System.out.println("产品列表发送变化咯！");
        //设置被观察者发生变化（把Observable类中的成员变量changed设为true），是通知观察者的前提
        this.setChanged();
        //把发送变化这件事通知观察者们，并告知变化的具体内容（本例为新增了什么商品）
        this.notifyObservers(productName);
    }
}

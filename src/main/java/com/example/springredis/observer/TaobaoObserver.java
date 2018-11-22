package com.example.springredis.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 淘宝推送接口
 */
public class TaobaoObserver implements Observer {
    /**
     * 观察者自我更新方法，观察者发送改变通知时触发该方法
     * @param o 被观察者对象
     * @param producName 被观察者改变的内容（传递的参数），本例为产品名称
     */
    @Override
    public void update(Observable o, Object producName) {
        String newProducName = producName==null?"":producName.toString();
        System.out.println("往淘宝推送了新商品:"+newProducName);
    }
}

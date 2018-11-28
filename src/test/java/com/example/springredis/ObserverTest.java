package com.example.springredis;

import com.example.springredis.observer.JingdongObserver;
import com.example.springredis.observer.ProductList;
import com.example.springredis.observer.TaobaoObserver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ObserverTest {
    @Test
    public void test(){
        ProductList productList = ProductList.getInstance();//获取产品列表(被观察者)
        JingdongObserver jingdongObserver = new JingdongObserver();
        TaobaoObserver taobaoObserver = new TaobaoObserver();
        productList.addObserver(jingdongObserver);//注册为产品列表对象的观察者
        productList.addObserver(taobaoObserver);
        //新增商品，并告诉观察者自己改变了，并把新增的商品发送给被观察者（电商同步接口），电商接口会自动调用update()方法以适应变化
        productList.addProduct("大力");
    }
}

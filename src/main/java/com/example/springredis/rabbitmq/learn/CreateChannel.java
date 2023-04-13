package com.example.springredis.rabbitmq.learn;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * rabbitmq创建信道
 */
public class CreateChannel {
    private static final String IP_ADDRESS = "192.168.92.129";

    private static final int PORT = 5672;
    public static void main(String[] args) {
        //创建连接用的工厂类
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(IP_ADDRESS);
        factory.setPort(PORT);
        factory.setUsername("root");
        factory.setPassword("123456");
        //创建连接
        try {
            Connection connection = factory.newConnection();
            //创建信道，创建好的信道就可以开始对mq服务端发送和接收消息了，需要注意的是，创建的信道是不能在线程间共享的,如果使用的是一个其他地方创建好的信道
            //可以使用channel.isOpen()方法检验信道是否还是开启状态
            Channel channel = connection.createChannel();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}

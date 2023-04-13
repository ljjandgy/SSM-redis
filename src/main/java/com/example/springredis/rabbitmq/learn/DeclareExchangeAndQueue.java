package com.example.springredis.rabbitmq.learn;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class DeclareExchangeAndQueue {
    private static final String IP_ADDRESS = "192.168.92.129";

    private static final int PORT = 5672;

    private static final String EXCHANGE_NAME = "textX";

    private static final String QUEUE_NAME = "testQueue";
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
            //客户端创建交换器，第一个参数是交换器名称，第二个是交换器类型，第三个是是否消息持久化
            //exchangeDeclare是一种重载了很多次的方法，详细参数如下：
            /**
             * exchange:交换器名称
             * type：交换器类型
             * durable：是否需要持久化。设置为true时，服务器重启后也不会丢失这个交换器
             * autoDelete：是否自动删除。设置为true时，当交换器从有队列、交换器绑定变为没有队列或者其他交换器绑定时，就会删除这个交换器
             * internal：是否内置：设置为true时，客户端无法直接访问交换器，只有其他交换器可以进行访问
             * argument：其他结构化参数
             */
            channel.exchangeDeclare(EXCHANGE_NAME,"direct",true);
            //客户端创建队列,参数分别是：队列名称，是否持久化，是否排他，是否自动删除
            /**
             * 详细参数如下：
             * queue：队列名称。不传系统会生成默认的名称
             * durable：是否持久化。也是重启时本身信息不丢失
             * exclusive：是否排他。如果设置为true，那么就只能创建它的连接可以进行访问，当创建它的连接断开时，删除队列
             * autoDelete：是否自动删除。设置为true时，当有过消费者连接到队列，然后所有消费者都断开时，就会删除队列
             */
            channel.queueDeclare(QUEUE_NAME,true,false,false,null);
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }
}

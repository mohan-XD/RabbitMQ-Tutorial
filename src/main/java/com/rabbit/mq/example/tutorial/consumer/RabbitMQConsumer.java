package com.rabbit.mq.example.tutorial.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import com.rabbit.mq.example.tutorial.config.RabbitMQConfig;

@Service
public class RabbitMQConsumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void receiveMessage(String msg){
        System.out.println("Message received : " + msg);
    }
}

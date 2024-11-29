package com.rabbit.mq.example.tutorial.controller;

import com.rabbit.mq.example.tutorial.producer.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rabbitmq")
public class RabbitMQController {

    @Autowired
    private RabbitMQProducer rabbitMQProducer;

    @PostMapping("/send")
    public String sendMessage(@RequestParam String message) {
        rabbitMQProducer.sendMessage(message);
        return "Message sent: " + message;
    }
}

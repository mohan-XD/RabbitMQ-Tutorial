package com.rabbit.mq.example.tutorial.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME = "my.first.queue";
    public static final String EXCHANGE_NAME = "my.first.exchange";
    public static final String ROUTING_KEY = "my.first.routingKey";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME, true); // Durable queue
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }
}

package com.allianz.training.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues="com.allianz.first")
public class RabbitListener1 {
    
    @RabbitHandler
    public void handleMessage(String msg) {
        System.out.println("Queue message from a.b.c "  + msg);
    }
    
}

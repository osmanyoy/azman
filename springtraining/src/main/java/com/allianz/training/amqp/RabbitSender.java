package com.allianz.training.amqp;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.scheduling.annotation.Scheduled;

public class RabbitSender {

    @Autowired
    private RabbitTemplate rabTemp;

    private int count;

    @Scheduled(fixedDelay = 10000)
    public void send() {
        rabTemp.convertAndSend("exchange1",
                               "a.b.c",
                               "C Message " + count++);
        
        Map<String, Object> headers = new HashMap<>();
        headers.put("order_me", "order1");
        Message<String> message = new GenericMessage<String>("C Message " + count++, headers);
        rabTemp.convertAndSend("test.exchange",
                               "osman.tosman",
                               message);
        
        // rabTemp.convertAndSend("exchange1",
        // "a.b.d",
        // "D Message " + count++);
    }

}

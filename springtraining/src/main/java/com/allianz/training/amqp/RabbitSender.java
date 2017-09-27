package com.allianz.training.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class RabbitSender {

    @Autowired
    private RabbitTemplate rabTemp;

    private int count;

    @Scheduled(fixedDelay = 10000)
    public void send() {
        rabTemp.convertAndSend("exchange1",
                               "a.b.*",
                               "C Message " + count++);
        // rabTemp.convertAndSend("exchange1",
        // "a.b.d",
        // "D Message " + count++);
    }

}

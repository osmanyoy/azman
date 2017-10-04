package com.allianz.training.amqp;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Argument;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

//@RabbitListener(queues = "com.allianz.first")

@Component
public class RabbitListener1 {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "test.mest", 
            autoDelete = "true", 
            arguments = @Argument(name = "x-message-ttl", 
                                value = "10000", 
                                type = "java.lang.Integer"),durable="true"), 
exchange = @Exchange(value = "test.exchange", type = ExchangeTypes.DIRECT, autoDelete = "false",durable="true"), 
key="osman.tosman",
arguments = {
@Argument(name = "x-match", value = "all"), @Argument(name = "foo", value = "bar"),
@Argument(name = "baz") }))
    @SendTo("exchange1/a.b.d")
    public String handleMessage(String msg, @Header("order_me") String headerTest) {
        System.out.println("Queue message from a.b.c " + msg + " header : " + headerTest);
        return "H:" + headerTest + " M:" + msg;
    }

}

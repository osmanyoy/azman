package com.allianz.training.amqp;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableRabbit
@EnableScheduling
public class RabbitConfig {

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("127.0.0.1");
        connectionFactory.setUsername("osman");
        connectionFactory.setPassword("osman12");
        return connectionFactory;
    }

    @Bean
    public AmqpAdmin amqpAdmin(ConnectionFactory connectionFactory) {
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
        return rabbitAdmin;
    }

    @Bean
    public Queue firstQueue() {
        Queue queue = new Queue("com.allianz.first");
        return queue;
    }

    @Bean
    public Queue secondQueue() {
        Queue queue = new Queue("com.allianz.second");
        return queue;
    }

    @Bean
    public Exchange exchange() {
        Exchange exchange = new TopicExchange("exchange1");
        return exchange;
    }

    @Bean
    public Binding binding1(Queue firstQueue, Exchange exchange) {
        return BindingBuilder.bind(firstQueue)
                             .to(exchange)
                             .with("a.b.c")
                             .noargs();
    }

    @Bean
    public Binding binding2(Queue secondQueue, Exchange exchange) {
        return BindingBuilder.bind(secondQueue)
                             .to(exchange)
                             .with("a.b.d")
                             .noargs();
    }
    
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        return rabbitTemplate;
    }
    
    @Bean
    public RabbitSender rabbitSender() {
        return new RabbitSender();
    }
    
    @Bean
    public RabbitListener1 listener1() {
        return new RabbitListener1();
    }
    
    @Bean
    public RabbitListener2 listener2() {
        return new RabbitListener2();
    }

}

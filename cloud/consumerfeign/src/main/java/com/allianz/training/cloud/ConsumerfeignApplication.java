package com.allianz.training.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableFeignClients
public class ConsumerfeignApplication {

    @Autowired
    private IMyConsumer cons;

    @RequestMapping(method = RequestMethod.GET, path = "/produce")
    public String callProducer() {
        return this.cons.serverInfo();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/test/{name}/{surname}")
    public String callProducer(@PathVariable("name") final String name,
                               @PathVariable("surname") final String surname) {
        return this.cons.test(name,
                              surname);
    }

    public static void main(final String[] args) {
        SpringApplication.run(ConsumerfeignApplication.class,
                              args);
    }
}

package com.allianz.training.ee.jms;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSDestinationDefinitions;


@Path("/jms")
public class JMSRest {

	@Inject
	private JMSContext context;

	@Resource(lookup = "java:/jms/queue/JMSSampleQueue")
	private Queue queue;

	@Resource(lookup = "java:/jms/topic/JMSSampleTopic")
	private Topic topic;

	@GET
	@Path("/queue")
	public String sendToQueue() {
        final Destination destination = this.queue;
        for (int i = 0; i < 10; i++) {
            String text = "This is message " + (i + 1);
            this.context.createProducer().send(destination, text);
        }
		return "OK";
	}
	@GET
	@Path("/topic")
	public String sendToTopic() {
        final Destination destination = this.topic;
        for (int i = 0; i < 10; i++) {
            String text = "This is message " + (i + 1);
            this.context.createProducer().send(destination, text);
        }
		return "OK";
	}

}

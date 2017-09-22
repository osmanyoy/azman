package com.allianz.training.ee.message;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.jboss.logging.Logger;

@Path("/message")
public class MessageRest {
	
	private static Logger log = Logger.getLogger(MessageRest.class);
	
	@Resource(lookup="java:/jms/queue/JmsQueueExample")
	private Queue queue;
	
	@Resource(lookup="java:/jms/queue/TestQueue")
	private Queue queue2;

	@Resource(lookup="java:/jms/topic/JmsTopicExample")
	private Topic topic;
	
	@Inject
	private JMSContext jmsContext;
	
	@GET
	public String sendMessage(@QueryParam("msg") String msg) {
		log.info("Sending message : " + msg + " Thread : " + Thread.currentThread().getName());
		jmsContext.createProducer().send(queue, msg);
		return "OK";
	}
	@GET
	@Path("/topic")
	public String sendMessageToTopic(@QueryParam("msg") String msg) {
		log.info("Sending topic message : " + msg + " Thread : " + Thread.currentThread().getName());
		jmsContext.createProducer().send(topic, msg);
		return "OK";
	}
	
	
	@GET
	@Path("/test")
	public String sendMessage3(@QueryParam("msg") String msg) {
		log.info("Sending message : " + msg + " Thread : " + Thread.currentThread().getName());
		jmsContext.createProducer().send(queue2, msg);
		return "OK";
	}

}

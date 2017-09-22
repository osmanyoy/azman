package com.allianz.training.ee.message;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSDestinationDefinitions;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.TextMessage;

import org.jboss.logging.Logger;

@MessageDriven(mappedName = "MyQueue", activationConfig = {
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "MyQueue"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })
public class QueueListener2 implements MessageListener {

	private static Logger log = Logger.getLogger(QueueListener2.class);

	@Override
	public void onMessage(Message message) {
		try {
			if (message instanceof TextMessage) {
				TextMessage textMessage = (TextMessage) message;
				log.info("Queue Listener 2 : " + textMessage.getText() + " Thread : "
						+ Thread.currentThread().getName());
			}

		} catch (Exception e) {
			log.error("Error occured while reading message : " + e.getMessage(), e);
		}
	}

}

package com.allianz.training.ee.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSDestinationDefinitions;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.jboss.logging.Logger;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "JMSSample"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") }, mappedName = "JMSSample")
public class MessageBeanSample2 implements MessageListener {

	private Logger logger = Logger.getLogger(MessageBeanSample2.class);

	public MessageBeanSample2() {
	}

	public void onMessage(Message message) {
		try {
			if (message instanceof TextMessage) {
				TextMessage textMessage = (TextMessage) message;
				if (logger.isInfoEnabled()) {
					logger.info("Received Message Consumer 2 : " + textMessage.getText());
				}

			}
		} catch (Exception e) {
			logger.error("ERROR : " + e.getMessage(), e);
		}

	}

}

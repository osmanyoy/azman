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


@JMSDestinationDefinitions(value = {
		@JMSDestinationDefinition(name = "java:/jms/queue/JMSSampleQueue", 
				destinationName = "JMSSample", 
				interfaceName = "javax.jms.Queue"),
		@JMSDestinationDefinition(name = "java:/jms/topic/JMSSampleTopic", destinationName = "JMSSampleTopic", interfaceName = "javax.jms.Topic")

})

@MessageDriven(mappedName = "JMSSample", activationConfig = {
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "JMSSample"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })
public class MessageBeanSample implements MessageListener {

	private Logger logger = Logger.getLogger(MessageBeanSample.class);

	public MessageBeanSample() {
	}

	public void onMessage(Message message) {
		try {
			if (message instanceof TextMessage) {
				TextMessage textMessage = (TextMessage) message;
				if (logger.isInfoEnabled()) {
					logger.info("Received Message Consumer 1 : " + textMessage.getText());
				}

			}
		} catch (Exception e) {
			logger.error("ERROR : " + e.getMessage(), e);
		}

	}

}

package com.allianz.training.ee.batch;

import java.util.Properties;

import javax.annotation.Resource;
import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSDestinationDefinitions;

@Path("/batch")
public class BatchRest {

	@GET
	@Path("/start")
	public String sendToQueue() {
		JobOperator jobOperator = BatchRuntime.getJobOperator();
		Properties props = new Properties();
		long start = jobOperator.start("jobListenerExample", props);
		return "OK";
	}

}

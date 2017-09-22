package com.allianz.training.ee.batch.example;

import javax.batch.api.listener.AbstractJobListener;
import javax.inject.Named;

@Named
public class MyJobListener extends AbstractJobListener {

    @Override
    public void beforeJob() {
        BatchListenerRecorder.batchListenersCountDownLatch.countDown();
        System.out.println("MyJobListener.beforeJob");
    }

    @Override
    public void afterJob() {
        BatchListenerRecorder.batchListenersCountDownLatch.countDown();
        System.out.println("MyJobListener.afterJob");
    }
}

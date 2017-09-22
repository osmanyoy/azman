package com.allianz.training.ee.batch.example;

import javax.batch.api.listener.AbstractStepListener;
import javax.inject.Named;

@Named
public class MyStepListener extends AbstractStepListener {

    @Override
    public void beforeStep() throws Exception {
        BatchListenerRecorder.batchListenersCountDownLatch.countDown();
        System.out.println("MyStepListener.beforeStep");
    }

    @Override
    public void afterStep() throws Exception {
        BatchListenerRecorder.batchListenersCountDownLatch.countDown();
        System.out.println("MyStepListener.afterStep");
    }
}

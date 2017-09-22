package com.allianz.training.ee.batch.example;

import javax.batch.api.chunk.listener.AbstractItemProcessListener;
import javax.inject.Named;

@Named
public class MyItemProcessorListener extends AbstractItemProcessListener {

    @Override
    public void beforeProcess(final Object item) throws Exception {
        BatchListenerRecorder.batchListenersCountDownLatch.countDown();
        System.out.println("MyItemProcessorListener.beforeProcess: " + item);
    }

    @Override
    public void afterProcess(final Object item,
                             final Object result) throws Exception {
        BatchListenerRecorder.batchListenersCountDownLatch.countDown();
        System.out.println("MyItemProcessorListener.afterProcess: " + item + ", " + result);
    }

    @Override
    public void onProcessError(final Object item,
                               final Exception ex) throws Exception {
        BatchListenerRecorder.batchListenersCountDownLatch.countDown();
        System.out.println("MyItemProcessorListener.onProcessError: " + item + ", " + ex.getLocalizedMessage());
    }
}

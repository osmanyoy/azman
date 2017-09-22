package com.allianz.training.ee.batch.example;

import javax.batch.api.chunk.listener.AbstractItemReadListener;
import javax.inject.Named;

@Named
public class MyItemReadListener extends AbstractItemReadListener {

    @Override
    public void beforeRead() throws Exception {
        BatchListenerRecorder.batchListenersCountDownLatch.countDown();
        System.out.println("MyItemReadListener.beforeRead");
    }

    @Override
    public void afterRead(final Object item) throws Exception {
        BatchListenerRecorder.batchListenersCountDownLatch.countDown();
        System.out.println("MyItemReadListener.afterRead: " + item);
    }

    @Override
    public void onReadError(final Exception ex) throws Exception {
        BatchListenerRecorder.batchListenersCountDownLatch.countDown();
        System.out.println("MyItemReadListener.onReadError: " + ex.getLocalizedMessage());
    }
}

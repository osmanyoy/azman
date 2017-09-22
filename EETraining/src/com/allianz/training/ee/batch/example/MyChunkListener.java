package com.allianz.training.ee.batch.example;

import javax.batch.api.chunk.listener.AbstractChunkListener;
import javax.inject.Named;

@Named
public class MyChunkListener extends AbstractChunkListener {

    @Override
    public void beforeChunk() throws Exception {
        BatchListenerRecorder.batchListenersCountDownLatch.countDown();
        System.out.println("MyChunkListener.beforeChunk");
    }

    @Override
    public void afterChunk() throws Exception {
        BatchListenerRecorder.batchListenersCountDownLatch.countDown();
        System.out.println("MyChunkListener.afterChunk");
    }
}

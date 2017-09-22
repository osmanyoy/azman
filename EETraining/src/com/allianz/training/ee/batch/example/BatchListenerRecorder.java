package com.allianz.training.ee.batch.example;


import java.util.concurrent.CountDownLatch;

public class BatchListenerRecorder {
    public static CountDownLatch batchListenersCountDownLatch = new CountDownLatch(60);
}

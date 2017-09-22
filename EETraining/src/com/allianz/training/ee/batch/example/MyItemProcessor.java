package com.allianz.training.ee.batch.example;

import javax.batch.api.chunk.ItemProcessor;
import javax.inject.Named;

@Named
public class MyItemProcessor implements ItemProcessor {

    @Override
    public Object processItem(final Object t) {
        System.out.println("processItem: " + t);

        return ((((MyInputRecord) t).getId() % 2) == 0) ? null : new MyOutputRecord(((MyInputRecord) t).getId() * 2);
    }
}

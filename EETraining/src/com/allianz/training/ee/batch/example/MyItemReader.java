package com.allianz.training.ee.batch.example;

import java.util.StringTokenizer;

import javax.batch.api.chunk.AbstractItemReader;
import javax.inject.Named;

@Named
public class MyItemReader extends AbstractItemReader {

    private final StringTokenizer tokens;

    public MyItemReader() {
        this.tokens = new StringTokenizer("1,2,3,4,5,6,7,8,9,10",
                                          ",");
    }

    @Override
    public MyInputRecord readItem() {
        if (this.tokens.hasMoreTokens()) {
            return new MyInputRecord(Integer.valueOf(this.tokens.nextToken()));
        }
        return null;
    }
}

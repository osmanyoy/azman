package com.allianz.training.ee.batch.example;

public class MyOutputRecord {
    private int id;

    public MyOutputRecord() {
    }

    public MyOutputRecord(final int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MyOutputRecord: " + this.id;
    }
}

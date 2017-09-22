package com.allianz.training.ee.batch.example;

public class MyInputRecord {
    private int id;

    public MyInputRecord() {
    }

    public MyInputRecord(final int id) {
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
        return "MyInputRecord: " + this.id;
    }
}

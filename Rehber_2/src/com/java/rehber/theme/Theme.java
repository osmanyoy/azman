package com.java.rehber.theme;


public class Theme {

    private String name;

    private String image;

    public Theme() {
    }

    public Theme(final String name,
                 final String image) {
        this.name = name;
        this.image = image;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(final String image) {
        this.image = image;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

package com.example.recyclerviewpractice;

public class Item {
    int Imagesource;
    String name;
    String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImagesource() {
        return Imagesource;
    }

    public void setImagesource(int imagesource) {
        Imagesource = imagesource;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Item( int imagesource, String name, String descriptiion) {
        this.name = name;
        this.Imagesource = imagesource;
        this.description = descriptiion;
    }
}

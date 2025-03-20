package com.example.petshop;

public class Item {
    int imageSource;
    String name;
    String description;

    public int getImageSource() {
        return imageSource;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Item(int imageSource, String name, String description) {
        this.imageSource = imageSource;
        this.name = name;
        this.description = description;
    }
}

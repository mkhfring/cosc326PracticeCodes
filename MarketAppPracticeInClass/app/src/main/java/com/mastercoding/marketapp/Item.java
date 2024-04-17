package com.mastercoding.marketapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

// This class acting as model class for our recyclerview
public class Item {
    int itemImg;
    @Expose
    String image;
    @SerializedName("title")
    @Expose
    String itemName;
    @SerializedName("description")
    @Expose
    String itemDesc;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Item(int itemImg, String itemName, String itemDesc) {
        this.itemImg = itemImg;
        this.itemName = itemName;
        this.itemDesc = itemDesc;
    }

    public int getItemImg() {
        return itemImg;
    }

    public void setItemImg(int itemImg) {
        this.itemImg = itemImg;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }
}


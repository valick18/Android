package com.example.food;

import java.util.ArrayList;
import java.util.List;

public class Dish {
    private String name;
    private String price;
    private int photoId;


    public Dish(String name, String price, int photoId) {
        this.name = name;
        this.price = price;
        this.photoId = photoId;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public int getPhotoId() {
        return photoId;
    }
}

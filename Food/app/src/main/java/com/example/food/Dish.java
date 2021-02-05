package com.example.food;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Dish {

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    @PrimaryKey(autoGenerate = true)
    private long ID;
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

    @Override
    public String toString() {
        return "Dish{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", photoId=" + photoId +
                '}';
    }

}

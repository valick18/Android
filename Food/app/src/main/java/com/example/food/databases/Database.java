package com.example.food.databases;

import androidx.room.RoomDatabase;

import com.example.food.Dish;

@androidx.room.Database(entities = {Dish.class}, version = 1)
public abstract class Database extends RoomDatabase {

    public abstract DishDao DishDao();

}

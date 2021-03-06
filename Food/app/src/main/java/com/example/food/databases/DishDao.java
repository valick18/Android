package com.example.food.databases;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.food.Dish;

import java.util.List;

@Dao
public interface DishDao {

    @Query("SELECT * FROM dish")
    List<Dish> getAll();

    @Query("SELECT * FROM dish WHERE ID = :ID")
    Dish getByID(long ID);

    @Insert(onConflict = OnConflictStrategy.ABORT)
    void insert(Dish dish);

    @Update
    void update(Dish dish);

    @Delete
    void delete(Dish dish);

    @Query("delete from dish where id>=0")
    void deleteAll();

}

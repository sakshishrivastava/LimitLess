package com.example.limitless.database;

import androidx.room.Dao;
import androidx.room.Ignore;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.limitless.model.ToDoList;

import java.util.List;

@Dao
public interface MyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertToDoList(List<ToDoList> toDoList);

    @Query("SELECT * FROM CountryDetails")
    List<ToDoList> getAllDetails();
}

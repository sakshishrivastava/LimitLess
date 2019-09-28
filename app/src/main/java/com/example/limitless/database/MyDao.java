package com.example.limitless.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.limitless.model.ToDoList;

import java.util.List;

@Dao
public interface MyDao {

    @Insert
    void insertToDoList(List<ToDoList> toDoList);

    @Query("SELECT * FROM CountryDetails")
    List<ToDoList> getAllDetails();
}

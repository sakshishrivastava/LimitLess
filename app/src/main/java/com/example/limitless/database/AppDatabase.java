package com.example.limitless.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.limitless.model.ToDoList;


@Database(entities = {ToDoList.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public static final String DB_NAME="country_db";
    private static AppDatabase instance;

    public static synchronized AppDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,DB_NAME).fallbackToDestructiveMigration().build();
        }
        return instance;
    }
    public abstract MyDao myDao();
}

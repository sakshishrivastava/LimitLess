package com.example.limitless.database;


import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class NestedTypeConverter {

    @TypeConverter
    public static List<Object> fromObject(String value) {
        Type listType = new TypeToken<List<Object>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayList(List<Object> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }
}

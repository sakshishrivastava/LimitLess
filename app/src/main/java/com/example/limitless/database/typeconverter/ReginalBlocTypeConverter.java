package com.example.limitless.database.typeconverter;


import androidx.room.TypeConverter;

import com.example.limitless.model.RegionalBloc;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class ReginalBlocTypeConverter {
    static Gson gson = new Gson();

    @TypeConverter
    public static List<RegionalBloc> storedStringToRegionalBloc(String data) {
        if (data == null) {
            return Collections.emptyList();
        }
        Type listType = new TypeToken<List<RegionalBloc>>() {}.getType();
        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String regionalBlocToStoredString(List<RegionalBloc> myObjects) {
        Gson gson = new Gson();
        return gson.toJson(myObjects);
    }
}

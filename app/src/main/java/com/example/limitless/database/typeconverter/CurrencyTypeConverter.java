package com.example.limitless.database.typeconverter;


import androidx.room.TypeConverter;

import com.example.limitless.model.Currency;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class CurrencyTypeConverter {
    static Gson gson = new Gson();

    @TypeConverter
    public static List<Currency> storedStringToCurrency(String data) {
        if (data == null) {
            return Collections.emptyList();
        }
        Type listType = new TypeToken<List<Currency>>() {}.getType();
        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String currencyToStoredString(List<Currency> myObjects) {
        Gson gson = new Gson();
        return gson.toJson(myObjects);
    }
}

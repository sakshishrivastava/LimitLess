package com.example.limitless.database.typeconverter;


import androidx.room.TypeConverter;

import com.example.limitless.model.Translations;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;

public class TranslationTypeConverter {
    static Gson gson = new Gson();

    @TypeConverter
    public static Translations storedStringToTranslations(String data) {
        if (data == null) {
            return (Translations) Collections.emptyList();
        }
        Type listType = new TypeToken<Translations>() {}.getType();
        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String translationsToStoredString(Translations myObjects) {
        Gson gson = new Gson();
        return gson.toJson(myObjects);
    }
}

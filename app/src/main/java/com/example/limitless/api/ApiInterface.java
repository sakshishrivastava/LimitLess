package com.example.limitless.api;

import com.example.limitless.model.ToDoList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("v2")
    Call<List<ToDoList>> getList();
}

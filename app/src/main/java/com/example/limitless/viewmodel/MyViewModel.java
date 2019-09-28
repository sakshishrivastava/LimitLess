package com.example.limitless.viewmodel;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.limitless.api.ApiClient;
import com.example.limitless.api.ApiInterface;
import com.example.limitless.database.AppDatabase;
import com.example.limitless.model.ToDoList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyViewModel extends AndroidViewModel {
    private final String TAG = getClass().getSimpleName();
    public MutableLiveData<List<ToDoList>> projectMutableLiveData = new MutableLiveData<>();
    private Context context;

    public MyViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public void apiCall(){
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        apiInterface.getList().enqueue(new Callback<List<ToDoList>>() {
            @Override
            public void onResponse(@NonNull Call<List<ToDoList>> call, @NonNull Response<List<ToDoList>> response) {
                if(response.isSuccessful()){
                    new SaveData(context,response.body()).execute();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<ToDoList>> call, @NonNull Throwable t) {

            }
        });
    }


   @SuppressLint("StaticFieldLeak")
   private class SaveData extends AsyncTask<Void,Void,Void>{
        Context context;
        List<ToDoList> lists;
        SaveData(Context context,List<ToDoList> lists){
            this.context = context;
            this.lists = lists;
        }

       @Override
       protected Void doInBackground(Void... voids) {
            AppDatabase.getInstance(context).myDao().insertToDoList(lists);
           return null;
       }

       @Override
       protected void onPostExecute(Void aVoid) {
           super.onPostExecute(aVoid);
           Log.e("DataBase","Updated");
            getData();
       }
   }

  public void getData()

    {
         @SuppressLint("StaticFieldLeak")
         class QueryData extends AsyncTask<Void, Void, List<ToDoList>> {
            List<ToDoList> lists;

            @Override
            protected List<ToDoList> doInBackground(Void... voids) {
                lists = AppDatabase.getInstance(context).myDao().getAllDetails();
                return lists;
            }

            @Override
            protected void onPostExecute(List<ToDoList> lists) {
                super.onPostExecute(lists);
                projectMutableLiveData.setValue(lists);
            }
        }
        new QueryData().execute();
    }
}

package com.example.limitless.viewmodel;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

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
            public void onResponse(Call<List<ToDoList>> call, Response<List<ToDoList>> response) {
                if(response.isSuccessful()){
                    new SaveData(context,response.body());
                }
            }

            @Override
            public void onFailure(Call<List<ToDoList>> call, Throwable t) {

            }
        });
    }


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

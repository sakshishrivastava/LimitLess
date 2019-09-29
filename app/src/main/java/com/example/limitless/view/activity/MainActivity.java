package com.example.limitless.view.activity;


import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.limitless.view.adapter.MyAdapter;
import com.example.limitless.R;
import com.example.limitless.databinding.ActivityMainBinding;
import com.example.limitless.model.ToDoList;
import com.example.limitless.viewmodel.MyViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    MyViewModel myViewModel;

    TextView textView;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        ActivityMainBinding activityMainBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);

        // bind RecyclerView
        RecyclerView recyclerView = activityMainBinding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


        myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        myAdapter =new MyAdapter();
        recyclerView.setAdapter(myAdapter);

        if (MyViewModel.isEmpty) {
            Log.e("DataBaseEmpty", String.valueOf(MyViewModel.isEmpty));
            myViewModel.apiCall();

        }
        myViewModel.getData();
        myViewModel.projectMutableLiveData.observe(this, new Observer<List<ToDoList>>() {
            @Override
            public void onChanged(List<ToDoList> lists) {
                // textView.setText(""+lists.size());
                myAdapter.setLists(lists);
            }
        });
    }
}

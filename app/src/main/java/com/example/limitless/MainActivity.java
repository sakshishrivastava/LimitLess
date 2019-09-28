package com.example.limitless;


import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.limitless.model.ToDoList;
import com.example.limitless.viewmodel.MyViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    MyViewModel myViewModel;

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        myViewModel= ViewModelProviders.of(this).get(MyViewModel.class);
        myViewModel.apiCall();
        myViewModel.getData();
        myViewModel.projectMutableLiveData.observe(this, new Observer<List<ToDoList>>() {
            @Override
            public void onChanged(List<ToDoList> lists) {
               //textView.setText(lists.get(0).getAlpha2Code().toString());
            }
        });
    }
}

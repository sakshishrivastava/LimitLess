package com.example.limitless.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.limitless.R;
import com.example.limitless.databinding.ItemsLayoutBinding;
import com.example.limitless.model.ToDoList;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<ToDoList> lists;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemsLayoutBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.items_layout, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ToDoList data = lists.get(position);
        holder.viewDataBinding.setModel(data);
    }

    @Override
    public int getItemCount() {
        if (lists != null) {
            return lists.size();
        } else return 0;
    }

    public void setLists(List<ToDoList> lists) {
        this.lists = lists;
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ItemsLayoutBinding viewDataBinding;

        public MyViewHolder(@NonNull ItemsLayoutBinding itemView) {
            super(itemView.getRoot());
            this.viewDataBinding = itemView;
        }
    }
}

package com.example.limitless;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.example.limitless.model.ToDoList;
import com.example.limitless.viewmodel.MyViewModel;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<ToDoList> lists;
    MyViewModel myViewModel;

   public MyAdapter(MyViewModel myViewModel){
        this.myViewModel = myViewModel;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater,viewType,parent,false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
       // holder.viewDataBinding.setVariable()
        holder.bind(myViewModel);
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
       ViewDataBinding viewDataBinding;
    public MyViewHolder(@NonNull ViewDataBinding itemView) {
        super(itemView.getRoot());
        this.viewDataBinding = itemView;
    }

    void bind(MyViewModel myViewModel){
        viewDataBinding.setVariable(BR.viewModel,myViewModel);
        viewDataBinding.executePendingBindings();
    }


}

public void setLists(List<ToDoList> lists){
       this.lists= lists;
}
}

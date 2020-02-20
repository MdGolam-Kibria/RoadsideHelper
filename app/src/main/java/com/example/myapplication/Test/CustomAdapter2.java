package com.example.myapplication.Test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

public class CustomAdapter2 extends RecyclerView.Adapter<ViewHolderD> {
    List<TestPojo> list;
    Context context;

    public CustomAdapter2(List<TestPojo> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderD onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.simple_test, parent, false);
        return new ViewHolderD(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderD holder, int position) {


        TestPojo currentData = list.get(position);
        holder.email.setText(currentData.getUserEmail());
        holder.password.setText(currentData.getUserPassword());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

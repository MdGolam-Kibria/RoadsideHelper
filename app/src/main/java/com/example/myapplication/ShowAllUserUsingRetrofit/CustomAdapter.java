package com.example.myapplication.ShowAllUserUsingRetrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<ViewHolderData> {
    List<PojoClass> list;
    Context context;

    public CustomAdapter(List<PojoClass> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample, parent, false);
        return new ViewHolderData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderData holder, int position) {
      PojoClass currentData = list.get(position);
        holder.id.setText(currentData.getUserId());
        holder.name.setText(currentData.getUserName());
        holder.email.setText(currentData.getUserEmail());
        holder.password.setText(currentData.getUserPassword());
        holder.type.setText(currentData.getUserType());
        holder.location.setText(currentData.getUserLocation());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

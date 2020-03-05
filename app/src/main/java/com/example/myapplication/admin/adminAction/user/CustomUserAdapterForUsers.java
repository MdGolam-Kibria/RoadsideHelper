package com.example.myapplication.admin.adminAction.user;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

public class CustomUserAdapterForUsers extends RecyclerView.Adapter<ViewHolderForShowAllUsers> {
    List<UserAndServiceProviderPojo> body;
    Context context;
    public CustomUserAdapterForUsers(List<UserAndServiceProviderPojo> body, Context context) {
        this.body = body;
        this.context  = context;
    }

    @NonNull
    @Override
    public ViewHolderForShowAllUsers onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.service_provider_simple_for_admin, parent, false);
        return new ViewHolderForShowAllUsers(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderForShowAllUsers holder, int position) {
        UserAndServiceProviderPojo currentData = body.get(position);
        holder.userName.setText(currentData.getUserName());
        holder.userEmail.setText(currentData.getUserEmail());
        holder.userPhone.setText(currentData.getUserPhone());
        holder.userLocation.setText(currentData.getUserLocation());
    }

    @Override
    public int getItemCount() {
        return body.size();
    }
}

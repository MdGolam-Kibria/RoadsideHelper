package com.example.myapplication.admin.adminAction.user.UserPack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.admin.adminAction.user.UserAndServiceProviderPojo;
import com.example.myapplication.recyclerViewClickLisInterface.RecycleViewItemAndLongClick;

import java.util.List;

public class CustomUserAdapter extends RecyclerView.Adapter<ViewHolderUserData> {
    List<UserAndServiceProviderPojo> list;
    Context context;



    public CustomUserAdapter(List<UserAndServiceProviderPojo> list, Context context) {
        this.list = list;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolderUserData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_provider_simple_for_admin, parent, false);
        return new ViewHolderUserData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderUserData holder, int position) {
        UserAndServiceProviderPojo currentData = list.get(position);
        holder.userName.setText(currentData.getUserName());
        holder.userEmail.setText(currentData.getUserEmail());
        holder.userPhone.setText(currentData.getUserPhone());
        holder.userLocation.setText(currentData.getUserLocation());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

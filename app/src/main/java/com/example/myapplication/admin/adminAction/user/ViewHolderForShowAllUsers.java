package com.example.myapplication.admin.adminAction.user;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class ViewHolderForShowAllUsers extends RecyclerView.ViewHolder {
    TextView userName,userEmail,userPhone,userLocation;
    public ViewHolderForShowAllUsers(@NonNull View itemView) {
        super(itemView);
        userName = itemView.findViewById(R.id.nameSe);
        userEmail = itemView.findViewById(R.id.emailSe);
        userPhone = itemView.findViewById(R.id.phoneSe);
        userLocation = itemView.findViewById(R.id.locationSe);
    }
}

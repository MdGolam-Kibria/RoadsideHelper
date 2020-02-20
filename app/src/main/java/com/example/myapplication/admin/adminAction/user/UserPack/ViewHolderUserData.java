package com.example.myapplication.admin.adminAction.user.UserPack;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.recyclerViewClickLisInterface.RecycleViewItemAndLongClick;

public class ViewHolderUserData extends RecyclerView.ViewHolder {
    TextView userName, userEmail, userPhone, userLocation;
    RecycleViewItemAndLongClick recycleViewItemAndLongClick;


    public ViewHolderUserData(@NonNull View itemView) {
        super(itemView);
        userName = itemView.findViewById(R.id.nameS);
        userEmail = itemView.findViewById(R.id.emailS);
        userPhone = itemView.findViewById(R.id.phoneS);
        userLocation = itemView.findViewById(R.id.locationS);

    }
}

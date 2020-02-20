package com.example.myapplication.ShowAllUserUsingRetrofit;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class ViewHolderData extends RecyclerView.ViewHolder {
    TextView id, name, email, phone, password, type, location;

    public ViewHolderData(@NonNull View itemView) {
        super(itemView);
        id = itemView.findViewById(R.id.id);
        name = itemView.findViewById(R.id.name);
        email = itemView.findViewById(R.id.email);
        phone = itemView.findViewById(R.id.phone);
        password = itemView.findViewById(R.id.password);
        type = itemView.findViewById(R.id.type);
        location = itemView.findViewById(R.id.location);
    }
}

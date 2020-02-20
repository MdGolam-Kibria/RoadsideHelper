package com.example.myapplication.Test;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class ViewHolderD extends RecyclerView.ViewHolder {
    TextView email, password;

    public ViewHolderD(@NonNull View itemView) {
        super(itemView);
        email = itemView.findViewById(R.id.emailT);
        password = itemView.findViewById(R.id.passwordT);
    }
}

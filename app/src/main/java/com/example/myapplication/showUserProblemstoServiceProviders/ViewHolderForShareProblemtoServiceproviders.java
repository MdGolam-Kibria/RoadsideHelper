package com.example.myapplication.showUserProblemstoServiceProviders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class ViewHolderForShareProblemtoServiceproviders extends RecyclerView.ViewHolder {
    ImageView problemImage;
    TextView problemDescription;
//    Button bidbtn;

    public ViewHolderForShareProblemtoServiceproviders(@NonNull View itemView) {
        super(itemView);
        problemImage = itemView.findViewById(R.id.pbImage);
        problemDescription = itemView.findViewById(R.id.pbDescrip);
//        bidbtn = itemView.findViewById(R.id.bidProbBtn);
    }
}

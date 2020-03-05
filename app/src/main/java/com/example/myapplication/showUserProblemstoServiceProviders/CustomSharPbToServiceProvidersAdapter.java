package com.example.myapplication.showUserProblemstoServiceProviders;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.Test.JsonImageConvert;

import java.util.List;

public class CustomSharPbToServiceProvidersAdapter extends RecyclerView.Adapter<ViewHolderForShareProblemtoServiceproviders> {
    List<ShareProblemToServiceProviders> body;
    Context applicationContext;

    public CustomSharPbToServiceProvidersAdapter(List<ShareProblemToServiceProviders> body, Context applicationContext) {
        this.body = body;
        this.applicationContext = applicationContext;
    }

    @NonNull
    @Override
    public ViewHolderForShareProblemtoServiceproviders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(applicationContext).inflate(R.layout.share_pb_to_service_providers_model, parent, false);
        return new ViewHolderForShareProblemtoServiceproviders(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderForShareProblemtoServiceproviders holder, int position) {
        ShareProblemToServiceProviders currentData = body.get(position);

        holder.problemDescription.setText(currentData.getProblemDescription());

        JsonImageConvert jsonImageConvert = new JsonImageConvert();
        Bitmap bitmap = jsonImageConvert.jsonimageConvertTOBitmap(currentData.getProblemImage());

        holder.problemImage.setImageBitmap(bitmap);
    }

    @Override
    public int getItemCount() {
        return body.size();
    }
}

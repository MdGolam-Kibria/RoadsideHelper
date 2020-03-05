package com.example.myapplication.admin.adminAction.ServiceProviderPack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.serviceProviderCheck.ServicePojo;

import java.util.List;

public class CustomAdapterForAdminShowServiceProviders extends RecyclerView.Adapter<ViewHolderShowAllServiceProviders> {
    List<ServicePojo> list;
    Context context;

    public CustomAdapterForAdminShowServiceProviders(List<ServicePojo> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderShowAllServiceProviders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.service_provider_simple_for_admin, parent, false);
        return new ViewHolderShowAllServiceProviders(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderShowAllServiceProviders holder, int position) {
            ServicePojo currentData = list.get(position);

            holder.serviceName.setText(currentData.getServiceName());
            holder.serviceEmail.setText(currentData.getServiceEmail());
            holder.servicePhone.setText(currentData.getServicePhone());
            holder.serviceLocation.setText(currentData.getServiceLocation());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

package com.example.myapplication.admin.adminAction.ServiceProviderPack;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class ViewHolderShowAllServiceProviders extends RecyclerView.ViewHolder {
    TextView serviceName,serviceEmail,servicePhone,serviceLocation;
    public ViewHolderShowAllServiceProviders(@NonNull View itemView) {
        super(itemView);
        serviceName = itemView.findViewById(R.id.nameSe);
        serviceEmail = itemView.findViewById(R.id.emailSe);
        servicePhone = itemView.findViewById(R.id.phoneSe);
        serviceLocation = itemView.findViewById(R.id.locationSe);
    }
}

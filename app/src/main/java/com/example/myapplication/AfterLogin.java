package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class AfterLogin extends Fragment {
    LinearLayout privateCar,motorCycle,truck,homeService;

    public AfterLogin() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.after_login, container, false);
        privateCar = view.findViewById(R.id.privateCar);
        motorCycle = view.findViewById(R.id.motorCycle);
        truck = view.findViewById(R.id.truck);

        homeService = view.findViewById(R.id.homeService);
        privateCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.containear, new UserDescription(), "userdescription").addToBackStack(null).commit();
            }
        });
        motorCycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.containear, new UserDescription(), "userdescription").addToBackStack(null).commit();
            }
        });
        truck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.containear, new UserDescription(), "userdescription").addToBackStack(null).commit();
            }
        });
        homeService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.containear, new UserDescription(), "userdescription").addToBackStack(null).commit();
            }
        });
        return view;
    }


}

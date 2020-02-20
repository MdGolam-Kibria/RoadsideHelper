package com.example.myapplication;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fast extends Fragment {
    ProgressBar progressBar;
    int progressValue;

Button btn1;
    public Fast() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_fast, container, false);

        progressBar = view.findViewById(R.id.progresBar);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
               startProgress();
               after();
            }
        });
        thread.start();
        return view;
    }

    private void startProgress() {
        for (progressValue=10;progressValue<=20;progressValue+=10){
            try {
                Thread.sleep(1000);
                progressBar.setProgress(progressValue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void after() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Snd snd = new Snd();
        fragmentTransaction.replace(R.id.containear,snd,"snd").commit();
    }

}

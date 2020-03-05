package com.example.myapplication.problemShowToServiceProviders;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.Retrofit.BaseUrl;
import com.example.myapplication.showUserProblemstoServiceProviders.CustomSharPbToServiceProvidersAdapter;
import com.example.myapplication.showUserProblemstoServiceProviders.ShareProblem;
import com.example.myapplication.showUserProblemstoServiceProviders.ShareProblemToServiceProviders;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ShowUserAllProblems extends Fragment {

    private RecyclerView recyclerViewpb;
    public ShowUserAllProblems() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_show_user_all_problems, container, false);
        recyclerViewpb = view.findViewById(R.id.recyclerViewForShowAllProblemsss);
        recyclerViewpb.setHasFixedSize(true);
        recyclerViewpb.setLayoutManager(new LinearLayoutManager(getContext()));
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl.BASE_URL)  //using rest api my rest api name is  = forRoadside into my pc
                .addConverterFactory(GsonConverterFactory.create()).build();

        ShareProblem userInterface = retrofit.create(ShareProblem.class);
        Call<List<ShareProblemToServiceProviders>> listCall = userInterface.getAllUserProblem();
        listCall.enqueue(new Callback<List<ShareProblemToServiceProviders>>() {
            @Override
            public void onResponse(Call<List<ShareProblemToServiceProviders>> call, Response<List<ShareProblemToServiceProviders>> response) {
                showIt(response.body());
            }

            @Override
            public void onFailure(Call<List<ShareProblemToServiceProviders>> call, Throwable t) {

            }
        });
        recyclerViewpb.setFocusableInTouchMode(true);

        recyclerViewpb.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
        return view;
    }
    private void showIt(List<ShareProblemToServiceProviders> body) {
        CustomSharPbToServiceProvidersAdapter custom  = new CustomSharPbToServiceProvidersAdapter(body,getContext());
        recyclerViewpb.setAdapter(custom);
    }
}

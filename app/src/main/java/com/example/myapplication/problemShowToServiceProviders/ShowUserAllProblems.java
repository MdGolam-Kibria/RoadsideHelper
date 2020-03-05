package com.example.myapplication.problemShowToServiceProviders;

import android.graphics.Movie;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.Retrofit.BaseUrl;
import com.example.myapplication.recyclerViewClickAndDeviderHundle.MyRecyclerViewDividerItemDecoration;
import com.example.myapplication.recyclerViewClickAndDeviderHundle.RecyclerTouchListener;
import com.example.myapplication.showUserProblemstoServiceProviders.CustomSharPbToServiceProvidersAdapter;
import com.example.myapplication.showUserProblemstoServiceProviders.ShareProblem;
import com.example.myapplication.showUserProblemstoServiceProviders.ShareProblemToServiceProviders;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ShowUserAllProblems extends Fragment {

    private RecyclerView recyclerViewpb;
    private List<Movie> movieList = new ArrayList<>();
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
        recyclerViewpb.setItemAnimator(new DefaultItemAnimator());
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
        return view;
    }
    private void showIt(final List<ShareProblemToServiceProviders> body) {
        CustomSharPbToServiceProvidersAdapter custom  = new CustomSharPbToServiceProvidersAdapter(body,getContext());
        recyclerViewpb.addItemDecoration(new MyRecyclerViewDividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL, 16));
        // above parameters for recycler view devider style class this copy from google link below
        //https://www.androidhive.info/2016/01/android-working-with-recycler-view/
        recyclerViewpb.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerViewpb, new RecyclerTouchListener.ClickListener() {
             @Override
            public void onClick(View view, int position) {

//                Movie movie = body.get(position);
                ShareProblemToServiceProviders movie = body.get(position);
                Toast.makeText(getContext(), movie.getProblemDescription() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {//
                Toast.makeText(getContext(), "long click on  "+body.get(position).getProblemDescription(), Toast.LENGTH_LONG).show();
            }
        }));
        recyclerViewpb.setAdapter(custom);
    }
}

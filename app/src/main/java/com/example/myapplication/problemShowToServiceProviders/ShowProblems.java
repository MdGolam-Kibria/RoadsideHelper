package com.example.myapplication.problemShowToServiceProviders;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.BaseAdapterTest.Custom;
import com.example.myapplication.R;
import com.example.myapplication.Retrofit.BaseUrl;
import com.example.myapplication.showUserProblemstoServiceProviders.ShareProblem;
import com.example.myapplication.showUserProblemstoServiceProviders.ShareProblemToServiceProviders;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShowProblems extends AppCompatActivity {
//    private RecyclerView recyclerView;
    ListView listViewForShowPb;
    String itemName[];
    int flags[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_problems);
//        recyclerView = findViewById(R.id.recyclerViewUser);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        listViewForShowPb = findViewById(R.id.listViewForShowPb);
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
    }

    private void showIt(List<ShareProblemToServiceProviders> body) {
        Custom custom = new Custom(this,body);
        listViewForShowPb.setAdapter(custom);

//        CustomSharPbToServiceProvidersAdapter customUserAdapter = new CustomSharPbToServiceProvidersAdapter(body, getApplicationContext());
//        recyclerView.setAdapter(customUserAdapter);

    }


}

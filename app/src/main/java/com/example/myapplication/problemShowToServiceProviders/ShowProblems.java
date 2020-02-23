package com.example.myapplication.problemShowToServiceProviders;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;

import com.example.myapplication.R;
import com.example.myapplication.Retrofit.BaseUrl;
import com.example.myapplication.admin.adminAction.user.UserAndServiceProviderPojo;
import com.example.myapplication.admin.adminAction.user.UserInterface;
import com.example.myapplication.admin.adminAction.user.UserPack.CustomUserAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShowProblems extends AppCompatActivity {
    private RecyclerView recyclerView;
//wow git
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_problems);
        recyclerView = findViewById(R.id.recyclerViewUser);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl.BASE_URL)  //using rest api my rest api name is  = forRoadside into my pc
                .addConverterFactory(GsonConverterFactory.create()).build();
        UserInterface userInterface = retrofit.create(UserInterface.class);
        Call<List<UserAndServiceProviderPojo>> listCall = userInterface.getAllUserInfoAll();
        listCall.enqueue(new Callback<List<UserAndServiceProviderPojo>>() {
            @Override
            public void onResponse(Call<List<UserAndServiceProviderPojo>> call, Response<List<UserAndServiceProviderPojo>> response) {
                showIt(response.body());
            }

            @Override
            public void onFailure(Call<List<UserAndServiceProviderPojo>> call, Throwable t) {

            }
        });
    }

    private void showIt(List<UserAndServiceProviderPojo> body) {
        CustomUserAdapter customUserAdapter = new CustomUserAdapter(body, getApplicationContext());
        recyclerView.setAdapter(customUserAdapter);
    }
}

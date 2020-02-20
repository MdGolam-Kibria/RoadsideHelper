package com.example.myapplication;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Retrofit.BaseUrl;
import com.example.myapplication.ShowAllUserUsingRetrofit.CustomAdapter;
import com.example.myapplication.ShowAllUserUsingRetrofit.PojoClass;
import com.example.myapplication.ShowAllUserUsingRetrofit.ServiceUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecycleForShowAllUser extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_for_show_all_user);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl.BASE_URL)  //using rest api my rest api name is  = forRoadside into my pc
                .addConverterFactory(GsonConverterFactory.create()).build();
        ServiceUser serviceUser = retrofit.create(ServiceUser.class);
        Call<List<PojoClass>> listCall = serviceUser.getAllUserInfo();
        listCall.enqueue(new Callback<List<PojoClass>>() {
            @Override
            public void onResponse(Call<List<PojoClass>> call, Response<List<PojoClass>> response) {

                if (response.isSuccessful()) {
                    showIt(response.body());
                }

            }

            @Override
            public void onFailure(Call<List<PojoClass>> call, Throwable t) {
                Toast.makeText(RecycleForShowAllUser.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void showIt(List<PojoClass> body) {
        CustomAdapter customAdapter = new CustomAdapter(body, getApplicationContext());
        recyclerView.setAdapter(customAdapter);
    }
}

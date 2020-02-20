package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.Retrofit.BaseUrl;
import com.example.myapplication.ShowAllUserUsingRetrofit.CustomAdapter;
import com.example.myapplication.Test.CustomAdapter2;
import com.example.myapplication.Test.TestPojo;
import com.example.myapplication.Test.TestService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TestActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl.BASE_URL)       //using rest api my rest api name is  = forRoadside rest api into my pc
                .addConverterFactory(GsonConverterFactory.create()).build();
        TestService testService = retrofit.create(TestService.class);
        Call<List<TestPojo>> listCall = testService.getAllUserInfo();
        listCall.enqueue(new Callback<List<TestPojo>>() {
            @Override
            public void onResponse(Call<List<TestPojo>> call, Response<List<TestPojo>> response) {
                Toast.makeText(TestActivity.this, response.body().toString(), Toast.LENGTH_LONG).show();
                if (response.isSuccessful()){

                    showIt(response.body());

                }else {
                    Toast.makeText(TestActivity.this, response.errorBody().toString(), Toast.LENGTH_LONG).show();;
                }
            }

            @Override
            public void onFailure(Call<List<TestPojo>> call, Throwable t) {

            }
        });
    }

    private void showIt(List<TestPojo> body) {
//        for (TestPojo get :body ){
//           get.
//        }
        CustomAdapter2 customAdapter2 = new CustomAdapter2(body, getApplicationContext());
        recyclerView.setAdapter(customAdapter2);
    }
}

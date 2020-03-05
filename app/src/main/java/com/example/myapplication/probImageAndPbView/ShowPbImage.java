package com.example.myapplication.probImageAndPbView;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.Retrofit.BaseUrl;
import com.example.myapplication.Test.JsonImageConvert;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShowPbImage extends AppCompatActivity {
    ImageView imageView;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_pb_image);
        imageView = findViewById(R.id.image);
        textView = findViewById(R.id.textJson);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BaseUrl.BASE_URL)  //using rest api my rest api name is  = forRoadside into my pc
                        .addConverterFactory(GsonConverterFactory.create()).build();
                OurRetrofitForImageRetrofit ourRetrofitForImageRetrofit = retrofit.create(OurRetrofitForImageRetrofit.class);
                Call<ProblemModel> listCall = ourRetrofitForImageRetrofit.getAllProblem();
                listCall.enqueue(new Callback<ProblemModel>() {
                    @Override
                    public void onResponse(Call<ProblemModel> call, Response<ProblemModel> response) {
                        if (response.isSuccessful()) {
                            problemShow(response.body());//for image show fromdatabase
                        }
                    }

                    @Override
                    public void onFailure(Call<ProblemModel> call, Throwable t) {

                    }
                });

            }
        });
    }

    private void problemShow(ProblemModel body) {//this method for byte[] to bitmap.

        JsonImageConvert jsonImageConvert = new JsonImageConvert();
        Bitmap bitmap = jsonImageConvert.jsonimageConvertTOBitmap(body.getProblemImage());
        imageView.setImageBitmap(bitmap);
        textView.setText(body.getProblemDescription());
    }
}



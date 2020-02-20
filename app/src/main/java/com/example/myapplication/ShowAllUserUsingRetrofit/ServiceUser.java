package com.example.myapplication.ShowAllUserUsingRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceUser {
    @GET("allUser")
    Call<List<PojoClass>> getAllUserInfo();
}

package com.example.myapplication.modelClass.loginModel.Retrofit;

import com.example.myapplication.modelClass.loginModel.UserPojo.UserPojo;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface OurRetrifit {
    @POST("authenticateUserBYUserByEmailAndPassword")
    Call<UserPojo> postData(@Body UserPojo pojo);
}

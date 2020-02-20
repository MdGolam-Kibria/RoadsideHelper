package com.example.myapplication.admin;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface OurRetrofitForAdmin {
    @GET("adminAllHere")
    Call<List<AdminModel>> getAllAdminInfo();
    @POST("authenticateAdminBYAdminEmailAndPassword")
    Call<AdminModel> postAdminInfo(@Body AdminModel adminModel);
}

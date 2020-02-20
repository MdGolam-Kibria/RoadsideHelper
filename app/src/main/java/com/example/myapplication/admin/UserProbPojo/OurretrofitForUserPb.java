package com.example.myapplication.admin.UserProbPojo;

import com.example.myapplication.SendDataToMysqlUsingRestAPI.Model;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface OurretrofitForUserPb {
    @POST("addUsersPB")
    Call<PbPojo> postData(@Body PbPojo pbPojo);
}

package com.example.myapplication.admin.adminAction.user;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserInterface {
    @GET("allUser")
    Call<List<UserAndServiceProviderPojo>> getAllUserInfoAll();
}

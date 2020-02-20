package com.example.myapplication.Test;

import com.example.myapplication.ShowAllUserUsingRetrofit.PojoClass;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TestService {
    @GET("allUser")
    Call<List<TestPojo>> getAllUserInfo();
}

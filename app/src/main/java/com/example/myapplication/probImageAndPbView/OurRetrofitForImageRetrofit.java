package com.example.myapplication.probImageAndPbView;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OurRetrofitForImageRetrofit {
    @GET("lastUserProblem")
    Call<ProblemModel> getAllProblem();
}

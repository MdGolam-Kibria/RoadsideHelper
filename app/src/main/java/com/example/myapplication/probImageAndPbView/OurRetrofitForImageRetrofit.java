package com.example.myapplication.probImageAndPbView;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OurRetrofitForImageRetrofit {
    @GET("allProblems")
    Call<ProblemModel> getAllProblem();
}

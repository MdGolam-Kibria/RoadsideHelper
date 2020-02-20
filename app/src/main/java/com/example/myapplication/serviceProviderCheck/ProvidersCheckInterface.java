package com.example.myapplication.serviceProviderCheck;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ProvidersCheckInterface {
    @POST("authenticateServiceProvidersBYUserByEmailAndPassword")
    Call<ServicePojo> postServiceProvidersData(@Body ServicePojo servicePojo);

    @GET("ServiceProvidersAllHere")
    Call<List<ServicePojo>> getAllServiceProvidersInfo();
}

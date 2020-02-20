package com.example.myapplication.SendDataToMysqlUsingRestAPI;

import com.example.myapplication.serviceProviderCheck.ServicePojo;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface OurRetroft {

    //for users
    @POST("addUsers")
    Call<Model> postData(@Body Model model);

    //for service providers
    @POST("addServiceProvider")
    Call<ServicePojo> postServiceProviderData(@Body ServicePojo servicePojo);


    ///coming soon for admin below
}

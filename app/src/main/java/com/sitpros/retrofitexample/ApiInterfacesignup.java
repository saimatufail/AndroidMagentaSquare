package com.sitpros.retrofitexample;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;


public interface ApiInterfacesignup {

    @Headers("content-type:application/json")
    @POST("V1/customers")
    Call<String> getLoginUser(@Body JsonObject model);

}
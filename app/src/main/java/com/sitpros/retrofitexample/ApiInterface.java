package com.sitpros.retrofitexample;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;


public interface ApiInterface {

    @Headers("content-type:application/json")
    @POST("V1/integration/admin/token")
    Call<String> getLoginUser(@Body JsonObject model);

    @Headers("content-type:application/json")
    @POST("V1/customers")
    Call<String> signUpUser(@Body JsonObject model);

}
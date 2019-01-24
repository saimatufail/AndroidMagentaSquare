package com.sitpros.retrofitexample;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiClientSignup {
    public static final String BASE_URL = "http://co2.techrecto.com/rest/all/";
    public static int whichServer = 0;

    private static Retrofit retrofit = null;
    private static ApiInterfacesignup apiInterfacesignup = null;

    public static Retrofit getClient() {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(120, TimeUnit.SECONDS)
                .writeTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    public static ApiInterfacesignup getWebServices() {
        return ApiClient.getClient().create(ApiInterfacesignup.class);
    }


    //------------------for file with more wait time.----------
    private static Retrofit retrofitForFile = null;
    private static ApiInterfacesignup apiInterfaceForFile = null;

    public static Retrofit getClientForFile() {
        //if (retrofitForFile == null) {

        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .build();

        retrofitForFile = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofitForFile;
    }

    public static ApiInterfacesignup getWebServicesForFile() {
        //if (apiInterfaceForFile == null) {
        //apiInterfaceForFile = ApiClient.getClientForFile().create(ApiInterface.class);
        return ApiClient.getClientForFile().create(ApiInterfacesignup.class);
        //}
        //return apiInterfaceForFile;
    }

    //Commit Added
}


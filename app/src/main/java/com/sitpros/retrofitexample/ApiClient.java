package com.sitpros.retrofitexample;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiClient {

    public static final String BASE_URL = "http://co2.techrecto.com/rest/all/";
    public static int whichServer = 0;

    private static Retrofit retrofit = null;
    private static ApiInterface apiInterface = null;
    private static ApiInterfaceLogin apiInterfaceLogin = null;

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

    public static ApiInterface getWebServices() {
        return ApiClient.getClient().create(ApiInterface.class);
    }

    public static ApiInterfaceLogin getWebServiceslogin() {
        return ApiClient.getClient().create(ApiInterfaceLogin.class);
    }
    //------------------for file with more wait time.----------
    private static Retrofit retrofitForFile = null;
    private static ApiInterface apiInterfaceForFile = null;
    private static ApiInterfaceLogin apiInterfaceForFilelogin = null;
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

    public static ApiInterface getWebServicesForFile() {
        //if (apiInterfaceForFile == null) {
        //apiInterfaceForFile = ApiClient.getClientForFile().create(ApiInterface.class);
        return ApiClient.getClientForFile().create(ApiInterface.class);
        //}
        //return apiInterfaceForFile;
    }
    public static ApiInterfaceLogin getWebServicesForFilelogin() {
        //if (apiInterfaceForFile == null) {
        //apiInterfaceForFile = ApiClient.getClientForFile().create(ApiInterface.class);
        return ApiClient.getClientForFile().create(ApiInterfaceLogin.class);
        //}
        //return apiInterfaceForFile;
    }

    //Commit Added
}

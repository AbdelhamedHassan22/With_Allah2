package com.SoftwareInversion.withallah.java.withallah;





import com.SoftwareInversion.withallah.java.withallah.Api.ApiInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {

    private static Retrofit retrofit;

    private static Retrofit getRetrofit(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl("https://api.pray.zone/v2/times/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static ApiInterface apInterface(){
        return getRetrofit().create(ApiInterface.class);
    }
}

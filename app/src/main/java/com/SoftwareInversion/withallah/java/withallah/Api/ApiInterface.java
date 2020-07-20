package com.SoftwareInversion.withallah.java.withallah.Api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("today.json")
    Call<Response> RESPONSE_CALL(@Query("city") String city);
}

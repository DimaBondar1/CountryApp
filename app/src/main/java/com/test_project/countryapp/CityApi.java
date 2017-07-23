package com.test_project.countryapp;

import com.test_project.countryapp.models.CityInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CityApi {

    @GET("wikipediaSearchJSON?username=aligarot")
    Call<CityInfo> getData(@Query("q") String q);
}

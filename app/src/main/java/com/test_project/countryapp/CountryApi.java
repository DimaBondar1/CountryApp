package com.test_project.countryapp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CountryApi {
    @GET("countriesToCities.json")
    Call<Map<String, String[]>> getData();
}

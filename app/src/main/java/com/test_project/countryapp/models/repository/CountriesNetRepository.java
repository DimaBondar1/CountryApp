package com.test_project.countryapp.models.repository;

import android.support.annotation.NonNull;
import android.util.Log;

import com.test_project.countryapp.CountryApi;
import com.test_project.countryapp.models.Country;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountriesNetRepository {

    @NonNull
    CountryApi countryApi;

    @NonNull
    CountryRepository countryRepository;

    public CountriesNetRepository(@NonNull CountryApi countryApi,
                                  @NonNull CountryRepository countryRepository) {
        this.countryApi = countryApi;
        this.countryRepository = countryRepository;
    }

    public void getData(){

        countryApi.getData().enqueue(new Callback<Map<String, String[]>>() {
            @Override
            public void onResponse(Call<Map<String, String[]>> call, Response<Map<String, String[]>> response) {
                countryRepository.removeAll();
                Map <String, String[]> map = response.body();
                for (String s:map.keySet()) {
                    if (s.isEmpty()){
                        continue;
                    }
                    Country country = new Country();
                    country.setName(s);
                    country.setCityList(map.get(s));
                    countryRepository.add(country);
                }
            }

            @Override
            public void onFailure(Call<Map<String, String[]>> call, Throwable t) {
                Log.e("CountryApi", "Fail");
            }
        });
    }
}

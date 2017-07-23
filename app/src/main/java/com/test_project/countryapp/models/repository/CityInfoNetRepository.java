package com.test_project.countryapp.models.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.test_project.countryapp.CityApi;
import com.test_project.countryapp.CountryApi;
import com.test_project.countryapp.models.CityInfo;
import com.test_project.countryapp.models.Country;
import com.test_project.countryapp.models.Geoname;
import com.test_project.countryapp.util.CallBack;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CityInfoNetRepository {
    @NonNull
    CityApi cityApi;

    @Nullable
    CallBack<Geoname> callBack;

    public CityInfoNetRepository(@NonNull CityApi cityApi){
        this.cityApi = cityApi;
    }

    public void setCallBack(@NonNull CallBack<Geoname> callBack) {
        this.callBack = callBack;
        Log.e("qq", callBack.toString());
    }

    public void getData(@NonNull String cityName){
        cityApi.getData(cityName).enqueue(new Callback<CityInfo>() {
            @Override
            public void onResponse(Call<CityInfo> call, Response<CityInfo> response) {
                CityInfo cityInfo = response.body();
                callBack.back(cityInfo.getGeonames().get(0));
            }

            @Override
            public void onFailure(Call<CityInfo> call, Throwable t) {
                Log.e("CityApi", "Fail");
            }
        });
    }
}

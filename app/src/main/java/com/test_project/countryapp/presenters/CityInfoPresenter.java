package com.test_project.countryapp.presenters;

import android.support.annotation.NonNull;

import com.test_project.countryapp.models.Geoname;
import com.test_project.countryapp.models.repository.CityInfoNetRepository;
import com.test_project.countryapp.util.CallBack;
import com.test_project.countryapp.views.cityInfo.CityInfoActivity;
import com.test_project.countryapp.views.cityInfo.CityInfoView;

public class CityInfoPresenter extends BasePresenter<CityInfoView>{

    @NonNull
    private CityInfoNetRepository cityInfoNet;

    public CityInfoPresenter(@NonNull CityInfoNetRepository cityInfoNet) {
        this.cityInfoNet = cityInfoNet;
    }

    @Override
    public void updateView() {
    }

    public void loadCityInfo(@NonNull Geoname geoname) {
        getView().setData(geoname);
    }

    public void setCallBack(@NonNull CallBack<Geoname> cityInfoActivity) {
        cityInfoNet.setCallBack(cityInfoActivity);
    }

    public void startLoad(@NonNull String city) {
        cityInfoNet.getData(city);
    }
}

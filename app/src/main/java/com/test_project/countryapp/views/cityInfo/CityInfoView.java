package com.test_project.countryapp.views.cityInfo;

import android.support.annotation.NonNull;

import com.test_project.countryapp.models.CityInfo;
import com.test_project.countryapp.models.Geoname;
import com.test_project.countryapp.views.BaseView;

public interface CityInfoView extends BaseView {

    void setData(@NonNull Geoname geoname);
}

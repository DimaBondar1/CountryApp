package com.test_project.countryapp.views.main;

import android.support.annotation.NonNull;

import com.test_project.countryapp.models.Country;
import com.test_project.countryapp.views.BaseView;
import com.test_project.countryapp.views.adapter.CityAdapter;

import java.util.List;

public interface MainView extends BaseView {

    void setSpinner(@NonNull List<Country> countries);

    void setCities(@NonNull List<String> list);
}

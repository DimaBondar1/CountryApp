package com.test_project.countryapp.presenters;

import android.support.annotation.NonNull;
import android.util.Log;

import com.test_project.countryapp.models.Country;
import com.test_project.countryapp.models.repository.CountryRepository;
import com.test_project.countryapp.views.main.MainView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainPresenter extends BasePresenter<MainView> {

    @NonNull
    private CountryRepository countryRepository;

    public MainPresenter(@NonNull CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public void updateView() {
        List<Country> list = countryRepository.getAll();
        getView().setSpinner(list);
        loadCities(list.get(0));
    }

    public void loadCities(@NonNull Country country){
        countryRepository.setCities(country);
        String[] cityList = country.getCityList();
        List<String> list = Arrays.asList(cityList);

        if(list.size() < 2 && list.get(list.size()-1) == ""){
            list = new ArrayList<>();
        }

        getView().setCities(list);
    }
}

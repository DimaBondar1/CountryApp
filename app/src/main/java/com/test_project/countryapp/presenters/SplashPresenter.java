package com.test_project.countryapp.presenters;

import android.support.annotation.NonNull;
import android.util.Log;

import com.test_project.countryapp.models.repository.CountriesNetRepository;
import com.test_project.countryapp.views.splash.SplashScreenView;

public class SplashPresenter extends BasePresenter<SplashScreenView> {

    @NonNull
    CountriesNetRepository countriesNetRepository;

    public SplashPresenter(@NonNull CountriesNetRepository countriesNetRepository) {
        this.countriesNetRepository = countriesNetRepository;
    }

    @Override
    public void updateView() {
    }

    public void startMainActivity(){
        getView().showMain();
    }

    public void loadData(){
        countriesNetRepository.getData();
    }
}

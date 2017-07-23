package com.test_project.countryapp.views.main;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.test_project.countryapp.R;
import com.test_project.countryapp.models.Country;
import com.test_project.countryapp.models.repository.CityInfoNetRepository;
import com.test_project.countryapp.presenters.MainPresenter;
import com.test_project.countryapp.routers.MainRouter;
import com.test_project.countryapp.views.BaseActivity;
import com.test_project.countryapp.util.CallBack;
import com.test_project.countryapp.views.adapter.CityAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnItemSelected;

public class MainActivity extends BaseActivity<MainPresenter, MainView>
        implements MainView, CallBack<String>{

    @Nullable
    List<Country> countryList;

    @BindView(R.id.countries)
    Spinner spinner;

    @BindView(R.id.cities)
    RecyclerView recyclerView;

    @NonNull
    private MainRouter mainRouter = new MainRouter(this);


    @Override
    public void setSpinner(@NonNull List<Country> countries) {
        countryList = countries;
        ArrayAdapter<Country> countryArrayAdapter = new ArrayAdapter<Country>(
                this,android.R.layout.simple_spinner_item, countryList);
        countryArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(countryArrayAdapter);
    }

    @Override
    public  void setCities(@NonNull List<String> list) {
        CityAdapter cities = new CityAdapter(list,this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(cities);
    }

    @Override
    protected void init() {
        getDataComponent().inject(this);
    }

    @NonNull
    @Override
    protected MainView getPresenterView() {
        return this;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.main_activity;
    }

    @OnItemSelected(R.id.countries)
    public void spinnerListener(Spinner spinner, int position){
        presenter.loadCities(countryList.get(position));
    }

    @Override
    public void back(String s) {
        mainRouter.showCityInfo(s);
    }
}

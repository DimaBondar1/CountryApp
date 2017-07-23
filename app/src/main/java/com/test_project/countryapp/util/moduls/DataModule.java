package com.test_project.countryapp.util.moduls;

import android.app.Application;
import android.support.annotation.NonNull;
import android.util.Log;

import com.test_project.countryapp.CityApi;
import com.test_project.countryapp.CountryApi;
import com.test_project.countryapp.models.DBHelper;
import com.test_project.countryapp.models.repository.CityInfoNetRepository;
import com.test_project.countryapp.models.repository.CityRepository;
import com.test_project.countryapp.models.repository.CountriesNetRepository;
import com.test_project.countryapp.models.repository.CountryRepository;
import com.test_project.countryapp.models.repository.DBCityRepository;
import com.test_project.countryapp.models.repository.DBCountryRepository;
import com.test_project.countryapp.presenters.CityInfoPresenter;
import com.test_project.countryapp.presenters.MainPresenter;
import com.test_project.countryapp.presenters.SplashPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class DataModule {

    private static final String BASE_URL = "https://raw.githubusercontent.com/David-Haim/CountriesToCitiesJSON/master/";
    private static final String WIKI_URL = "http://api.geonames.org/";

    @NonNull
    @Provides
    @Singleton
    public SplashPresenter getSplashPresenter(CountriesNetRepository countriesNetRepository){
        Log.e("!!","11");
        return new SplashPresenter(countriesNetRepository);
    }

    @NonNull
    @Provides
    @Singleton
    public CountryApi getCountryApi(){
        Log.e("!!","22");
        CountryApi countryApi;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        countryApi = retrofit.create(CountryApi.class);

        return countryApi;
    }

    @NonNull
    @Provides
    @Singleton
    public CityApi getCityApi(){
        Log.e("!!","211");
        CityApi cityApi;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WIKI_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        cityApi = retrofit.create(CityApi.class);

        return cityApi;
    }

    @NonNull
    @Provides
    @Singleton
    public CityInfoNetRepository getCityInfoNetRepository(CityApi cityApi){
        return new CityInfoNetRepository(cityApi);
    }

    @NonNull
    @Provides
    @Singleton
    public CityInfoPresenter getCityInfoPresenter(CityInfoNetRepository cityInfoNetRepository){
        return new CityInfoPresenter(cityInfoNetRepository);
    }

    @NonNull
    @Provides
    @Singleton
    public CountriesNetRepository getCountriesNetRepository(CountryApi countryApi,
                                                            CountryRepository countryRepository){
        Log.e("!!","33");
        return new CountriesNetRepository(countryApi, countryRepository);
    }

    @NonNull
    @Provides
    @Singleton
    public DBHelper getDBHelper(Application application){
        return new DBHelper(application);
    }

    @NonNull
    @Provides
    @Singleton
    public CountryRepository getCountryRepository(DBHelper dbHelper){
        return new DBCountryRepository(dbHelper.getReadableDatabase());
    }

    @NonNull
    @Provides
    @Singleton
    public CityRepository getCityRepository(DBHelper dbHelper, CountryRepository countryRepository){
        return new DBCityRepository(dbHelper.getReadableDatabase(), countryRepository);
    }

    @NonNull
    @Provides
    @Singleton
    public MainPresenter getMainPresenter(CountryRepository countryRepository){
        return new MainPresenter(countryRepository);
    }
}

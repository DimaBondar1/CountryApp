package com.test_project.countryapp.views.cityInfo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.test_project.countryapp.R;
import com.test_project.countryapp.models.CityInfo;
import com.test_project.countryapp.models.Geoname;
import com.test_project.countryapp.presenters.CityInfoPresenter;
import com.test_project.countryapp.routers.CityInfoRouter;
import com.test_project.countryapp.routers.MainRouter;
import com.test_project.countryapp.util.CallBack;
import com.test_project.countryapp.views.BaseActivity;

import java.util.zip.Inflater;

import butterknife.BindView;

public class CityInfoActivity extends BaseActivity<CityInfoPresenter, CityInfoView>
        implements CityInfoView, CallBack<Geoname> {

    @BindView(R.id.about)
    TextView about;

    @BindView(R.id.link)
    TextView link;

    @BindView(R.id.head)
    TextView title;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter.setCallBack(this);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String city = getIntent().getStringExtra(MainRouter.CITY);

        presenter.startLoad(city);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home: {
                onBackPressed();
                return true;
            }
        }
        return false;
    }

    @Override
    protected void init() {
        getDataComponent().inject(this);
    }

    @NonNull
    @Override
    protected CityInfoView getPresenterView() {
        return this;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.city_info;
    }

    @Override
    public void setData(Geoname geoname) {
        String linkStr = "http://"+geoname.getWikipediaUrl();

        progressBar.setVisibility(View.INVISIBLE);
        title.setText(geoname.getTitle());
        about.setText(geoname.getSummary());
        link.setText(linkStr);
        Linkify.addLinks(link, Linkify.ALL);
    }

    @Override
    public void back(Geoname geoname) {
        presenter.loadCityInfo(geoname);
    }
}

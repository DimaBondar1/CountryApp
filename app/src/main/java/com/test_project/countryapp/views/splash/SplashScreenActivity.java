package com.test_project.countryapp.views.splash;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.test_project.countryapp.R;
import com.test_project.countryapp.presenters.SplashPresenter;
import com.test_project.countryapp.routers.SplashScreenRouter;
import com.test_project.countryapp.views.BaseActivity;

import javax.inject.Inject;

public class SplashScreenActivity extends BaseActivity<SplashPresenter, SplashScreenView>
        implements SplashScreenView {

    @NonNull
    private SplashScreenRouter startRouter = new SplashScreenRouter(SplashScreenActivity.this);

    private static final long TIME_WAIT = 2000;

    @NonNull
    private final Handler handler = new Handler();

    @NonNull
    private final Runnable runnable = new Runnable() {

        @Override
        public void run() {
            presenter.startMainActivity();
            finish();
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter.loadData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(runnable, TIME_WAIT);
    }

    @Override
    protected void onPause() {
        handler.removeCallbacks(runnable);
        super.onPause();
    }


    @Override
    protected void init() {
        getDataComponent().inject(this);
    }

    @Override
    @NonNull
    protected SplashScreenView getPresenterView() {
        return this;
    }

    @Override
    @NonNull
    protected int getLayoutRes() {
        return R.layout.activity_splash_screen;
    }

    @Override
    public void showMain() {
        startRouter.showMainActivity();
    }

}

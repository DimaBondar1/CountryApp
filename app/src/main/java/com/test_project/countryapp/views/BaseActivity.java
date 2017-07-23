package com.test_project.countryapp.views;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.test_project.countryapp.presenters.BasePresenter;
import com.test_project.countryapp.routers.BaseNavigationRouter;
import com.test_project.countryapp.util.components.AppComponent;
import com.test_project.countryapp.util.components.DaggerAppComponent;
import com.test_project.countryapp.util.components.DataComponent;
import com.test_project.countryapp.util.moduls.AppModule;

import javax.inject.Inject;

import butterknife.ButterKnife;

public abstract class BaseActivity<P extends BasePresenter<V>, V extends BaseView>
        extends AppCompatActivity {

    @Inject
    @Nullable
    protected P presenter;

    @Nullable
    AppComponent appComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());

        init();

        ButterKnife.bind(this);

        presenter.bindView(getPresenterView());
    }

    @Override
    protected void onDestroy() {
        presenter.unbindView();

        super.onDestroy();
    }

    @NonNull
    public DataComponent getDataComponent() {
        if(appComponent == null){
            appComponent = DaggerAppComponent
                    .builder()
                    .appModule(new AppModule(getApplication()))
                    .build();
        }
        return appComponent.provideDataComponent();
    }

    protected abstract void init();

    @NonNull
    protected abstract V getPresenterView();

    @LayoutRes
    protected abstract int getLayoutRes();
}

package com.test_project.countryapp.presenters;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.test_project.countryapp.views.BaseView;

public abstract class BasePresenter<V extends BaseView> {

    @Nullable
    private V view;

    public void bindView(@NonNull V view){
        this.view = view;

        updateView();
    }

    public void unbindView(){
        view = null;
    }

    @Nullable
    public V getView(){
        return view;
    }

    public boolean isReady(){
        return (view == null);
    }

    public abstract void updateView();
}

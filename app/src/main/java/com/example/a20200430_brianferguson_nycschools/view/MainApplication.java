package com.example.a20200430_brianferguson_nycschools.view;

import android.app.Application;

import com.example.a20200430_brianferguson_nycschools.di.component.DaggerMainComponent;
import com.example.a20200430_brianferguson_nycschools.di.component.MainComponent;
import com.example.a20200430_brianferguson_nycschools.di.module.MainApplicationModule;
import com.example.a20200430_brianferguson_nycschools.di.module.MainViewModelFactoryModule;

public class MainApplication extends Application {
    private static MainComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerMainComponent.builder()
                .mainViewModelFactoryModule(new MainViewModelFactoryModule())
                .mainApplicationModule(new MainApplicationModule(this))
                .build();
    }

    public static MainComponent getComponent(){
        return component;
    }
}

package com.example.a20200430_brianferguson_nycschools.di.module;

import com.example.a20200430_brianferguson_nycschools.view.MainApplication;

import dagger.Module;
import dagger.Provides;

@Module
public class MainApplicationModule {

    private MainApplication context;

    public MainApplicationModule(MainApplication context){
        this.context = context;
    }

    @Provides
    public MainApplication providesApplication(){
        return context;
    }
}

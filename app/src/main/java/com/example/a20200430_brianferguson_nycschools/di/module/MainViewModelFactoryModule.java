package com.example.a20200430_brianferguson_nycschools.di.module;

import com.example.a20200430_brianferguson_nycschools.network.SchoolsFactory;
import com.example.a20200430_brianferguson_nycschools.viewmodel.MainViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class MainViewModelFactoryModule {

    @Provides
    public MainViewModelFactory providesViewModelFactory(SchoolsFactory schoolsFactory){
        return new MainViewModelFactory(schoolsFactory);
    }
}

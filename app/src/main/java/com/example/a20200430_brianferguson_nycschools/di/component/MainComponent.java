package com.example.a20200430_brianferguson_nycschools.di.component;

import com.example.a20200430_brianferguson_nycschools.di.module.MainApplicationModule;
import com.example.a20200430_brianferguson_nycschools.di.module.MainViewModelFactoryModule;
import com.example.a20200430_brianferguson_nycschools.view.MainActivity;

import dagger.Component;

@Component(modules = {MainApplicationModule.class, MainViewModelFactoryModule.class})
public interface MainComponent {
    void inject(MainActivity activity);
}

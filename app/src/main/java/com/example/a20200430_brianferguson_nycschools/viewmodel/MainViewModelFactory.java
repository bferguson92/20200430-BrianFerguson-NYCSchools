package com.example.a20200430_brianferguson_nycschools.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.a20200430_brianferguson_nycschools.network.SchoolsFactory;

import javax.inject.Inject;

public class MainViewModelFactory implements ViewModelProvider.Factory {

    private SchoolsFactory schoolsFactory;

    @Inject
    public MainViewModelFactory(SchoolsFactory schoolsFactory){
        this.schoolsFactory = schoolsFactory;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        MainViewModel viewModel = new MainViewModel(schoolsFactory);
        return (T) viewModel;
    }
}

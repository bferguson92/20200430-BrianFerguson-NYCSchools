package com.example.a20200430_brianferguson_nycschools.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.a20200430_brianferguson_nycschools.model.SATScoresResponse;
import com.example.a20200430_brianferguson_nycschools.model.SchoolResponse;
import com.example.a20200430_brianferguson_nycschools.network.SchoolsFactory;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class MainViewModel extends ViewModel {

    private SchoolsFactory schoolsFactory;

    public MainViewModel(SchoolsFactory schoolsFactory){
        this.schoolsFactory = schoolsFactory;
    }

    public Observable<List<SchoolResponse>> getSchools() {
        return schoolsFactory.getSchools();
    }

    public Observable<List<SATScoresResponse>> getSATScores() {
        return schoolsFactory.getSATScores();
    }
}

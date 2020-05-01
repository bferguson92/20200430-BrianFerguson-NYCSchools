package com.example.a20200430_brianferguson_nycschools.network;

import com.example.a20200430_brianferguson_nycschools.model.SATScoresResponse;
import com.example.a20200430_brianferguson_nycschools.model.SchoolResponse;

import java.util.List;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SchoolsFactory {
    private SchoolsService schoolsService;

    public SchoolsFactory() {
        schoolsService = createService();
    }

    private SchoolsService createService() {
        Retrofit builder = new Retrofit.Builder()
                .baseUrl("https://data.cityofnewyork.us/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();

        return builder.create(SchoolsService.class);
    }

    public Observable<List<SchoolResponse>> getSchools() {
        return schoolsService.getSchools();
    }

    public Observable<List<SATScoresResponse>> getSATScores() {
        return schoolsService.getSATScores();
    }
}

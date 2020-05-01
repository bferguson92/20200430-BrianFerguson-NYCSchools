package com.example.a20200430_brianferguson_nycschools.network;

import com.example.a20200430_brianferguson_nycschools.model.SATScoresResponse;
import com.example.a20200430_brianferguson_nycschools.model.SchoolResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface SchoolsService {
    @GET("resource/s3k6-pzi2.json")
    Observable<List<SchoolResponse>> getSchools();

    @GET("resource/f9bf-2cp4.json")
    Observable<List<SATScoresResponse>> getSATScores();
}

package com.example.a20200430_brianferguson_nycschools;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.example.a20200430_brianferguson_nycschools.model.SATScoresResponse;
import com.example.a20200430_brianferguson_nycschools.model.SchoolResponse;
import com.example.a20200430_brianferguson_nycschools.network.SchoolsFactory;
import com.example.a20200430_brianferguson_nycschools.viewmodel.MainViewModel;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observers.TestObserver;

import static junit.framework.TestCase.assertNotNull;

public class MainViewModelTest {

    private MainViewModel classUnderTest;

    @Mock
    SchoolsFactory schoolsFactory;

    @Rule
    public InstantTaskExecutorRule rule = new InstantTaskExecutorRule();

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        classUnderTest = new MainViewModel(schoolsFactory);
    }

    @Test
    public void shouldReturnSchoolData(){
        assertNotNull(classUnderTest);
        Mockito.doReturn(Observable.just(new ArrayList<SchoolResponse>()))
                .when(schoolsFactory).getSchools();
        TestObserver<List<SchoolResponse>>
                testObserver = classUnderTest.getSchools().test();

        Mockito.verify(schoolsFactory).getSchools();
        testObserver.assertComplete();
        testObserver.dispose();
    }

    @Test
    public void shouldReturnSATScoreData() {
        assertNotNull(classUnderTest);
        Mockito.doReturn(Observable.just(new ArrayList<SATScoresResponse>()))
                .when(schoolsFactory).getSATScores();
        TestObserver<List<SATScoresResponse>> testObserver = classUnderTest.getSATScores().test();

        Mockito.verify(schoolsFactory).getSATScores();
        testObserver.assertComplete();
        testObserver.dispose();
    }
}

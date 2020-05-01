package com.example.a20200430_brianferguson_nycschools.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a20200430_brianferguson_nycschools.R;
import com.example.a20200430_brianferguson_nycschools.adapter.SchoolsAdapter;
import com.example.a20200430_brianferguson_nycschools.model.SATScoresResponse;
import com.example.a20200430_brianferguson_nycschools.model.SchoolResponse;
import com.example.a20200430_brianferguson_nycschools.viewmodel.MainViewModel;
import com.example.a20200430_brianferguson_nycschools.viewmodel.MainViewModelFactory;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements SchoolsAdapter.OnItemClickListener {

    private MainViewModel mainViewModel;
    @Inject
    public MainViewModelFactory mainViewModelFactory;
    private RecyclerView recyclerView;
    private TextView errorText;
    private Disposable schoolDisposable;
    private Disposable scoresDisposable;

    private List<SchoolResponse> schools;
    private List<SATScoresResponse> scores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.school_list);
        errorText = findViewById(R.id.error_text);

        ((MainApplication)getApplicationContext()).getComponent().inject(this);

        mainViewModel = mainViewModelFactory.create(MainViewModel.class);

        setUpRecycelerView();
        getScores();
    }

    private void setUpRecycelerView() {
        schoolDisposable = mainViewModel.getSchools().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(schools -> {
                    this.schools = schools;
                    DividerItemDecoration divider = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);

                    recyclerView.addItemDecoration(divider);
                    recyclerView.setAdapter(new SchoolsAdapter(this.schools, this ));
                    recyclerView.setLayoutManager(new LinearLayoutManager(this));
                }, error -> {
                    errorText.setVisibility(View.VISIBLE);
                });
    }

    private void getScores() {
        scoresDisposable = mainViewModel.getSATScores().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(scores -> {
                   this.scores = scores;
                }, error -> {
                    Toast toast = Toast.makeText(this, "Could not retrieve SAT Scores", Toast.LENGTH_SHORT);
                    toast.show();
                });
    }

    @Override
    public void onItemClick(SchoolResponse school) {
        boolean schoolFound = false;

        for(int i = 0; i < scores.size(); i++) {
            if(school.getDbn().equals(scores.get(i).getDbn())) {
                schoolFound = true;

                Intent intent = new Intent(this, ScoresActivity.class);
                intent.putExtra("SCHOOL", scores.get(i));
                startActivity(intent);
            }
        }

        if(!schoolFound) {
            Toast toast = Toast.makeText(this, "Could not retrieve data for school", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        schoolDisposable.dispose();
        scoresDisposable.dispose();
    }
}

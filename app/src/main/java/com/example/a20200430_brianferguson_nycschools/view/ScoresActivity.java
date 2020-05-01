package com.example.a20200430_brianferguson_nycschools.view;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a20200430_brianferguson_nycschools.R;
import com.example.a20200430_brianferguson_nycschools.model.SATScoresResponse;

public class ScoresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);

        TextView schoolNameText = findViewById(R.id.scores_name);
        TextView mathScoreText = findViewById(R.id.math_score);
        TextView readingScoreText = findViewById(R.id.reading_score);
        TextView writingScoreText = findViewById(R.id.writing_score);
        TextView numberOfTakersText = findViewById(R.id.number_of_takers);

        SATScoresResponse scores = getIntent().getParcelableExtra("SCHOOL");

        if (scores != null) {
            schoolNameText.setText(scores.getSchoolName());
            mathScoreText.append(scores.getSatMathAvgScore());
            readingScoreText.append(scores.getSatCriticalReadingAvgScore());
            writingScoreText.append(scores.getSatWritingAvgScore());
            numberOfTakersText.append(scores.getNumOfSatTestTakers());
        }
    }
}

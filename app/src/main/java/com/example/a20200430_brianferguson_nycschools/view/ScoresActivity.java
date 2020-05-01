package com.example.a20200430_brianferguson_nycschools.view;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.widget.TextView;

        import com.example.a20200430_brianferguson_nycschools.R;

public class ScoresActivity extends AppCompatActivity {

    private TextView mathScoreText;
    private TextView readingScoreText;
    private TextView writingScoreText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);

        mathScoreText = findViewById(R.id.math_score);
        readingScoreText = findViewById(R.id.reading_score);
        writingScoreText = findViewById(R.id.writing_score);

        mathScoreText.append(getIntent().getStringExtra("MATH"));
        readingScoreText.append(getIntent().getStringExtra("READING"));
        writingScoreText.append(getIntent().getStringExtra("WRITING"));

    }
}

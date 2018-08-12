package com.josephpark.pokerpal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class QuizResultsActivity extends AppCompatActivity {

    private TextView scoreText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_results);

        getSupportActionBar().show();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        String score = getIntent().getStringExtra("score");
        scoreText = findViewById(R.id.scoreText);
        scoreText.setText(score);
    }
}

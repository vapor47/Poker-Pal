package com.josephpark.pokerpal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PracticeMenuActivity extends AppCompatActivity {

//    private Button EV;
    private Button CountingOuts;
    private Button PotOdds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_menu);

        Button EV = findViewById(R.id.expected_value_btn);
        CountingOuts = findViewById(R.id.counting_outs_btn);

        CountingOuts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), QuizActivity.class);
                intent.putExtra("subject", "Counting Outs");
                startActivity(intent);
            }
        });
    }

    public void gotoEVQuiz(View view){
        Intent intent = new Intent(this, QuizActivity.class);
        intent.putExtra("subject", "EV");
        startActivity(intent);
    }

}

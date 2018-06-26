package com.josephpark.pokerpal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gotoPractice(View view){
        Intent intent = new Intent(this, PracticeMenuActivity.class);
        startActivity(intent);
    }

    public void gotoCalculators(View view){
        Intent intent = new Intent(this, CalculatorsMenuActivity.class);
        startActivity(intent);
    }
}

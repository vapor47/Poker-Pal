package com.josephpark.pokerpal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CalculatorsMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculators_menu);
    }

    public void gotoExpectedValue(View view){
        Intent intent = new Intent(this, ExpectedValueCalculatorActivity.class);
        startActivity(intent);
    }
}

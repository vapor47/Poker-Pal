package com.josephpark.pokerpal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CalculatorsMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculators_menu);

        Button EVtest = findViewById(R.id.button2);
        Button equityCalc = findViewById(R.id.equity_calc_btn);

        EVtest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ExpectedValueCalculatorV2.class);
                startActivity(intent);
            }
        });

        equityCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EquityCalculatorActivity.class);
                startActivity(intent);
            }
        });
    }

    public void gotoExpectedValue(View view){
        Intent intent = new Intent(this, ExpectedValueCalculatorActivity.class);
        startActivity(intent);
    }
}

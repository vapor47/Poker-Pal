package com.josephpark.pokerpal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ExpectedValueCalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expected_value_calculator);
    }

    public void calculateExpectedValue(View view){
        EditText potSize = findViewById(R.id.potSize);
        EditText betSize = findViewById(R.id.betSize);
        EditText winPercentage = findViewById(R.id.winPercentage);
        TextView EVText = findViewById(R.id.expectedValueAnswerText);

        double pot = Double.parseDouble(potSize.getText().toString());
        double bet = Double.parseDouble(betSize.getText().toString());
        double win = Double.parseDouble(winPercentage.getText().toString()) / 100;

        // EV = (%W * $W) - (%L * $L)
        double EV = (win * pot) - ((1 - win) * bet);
        EVText.setText(String.format("$%.2f", EV));
    }

}

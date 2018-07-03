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
    /*TODO
    app crashes when calculating with some forms unfilled
        put in prefilled values
    for negative EV, put '-' in front of dollar sign like '-$1.00'
    for percentage of winning, choose between current percentage or
        have editText for number of outs and buttons for current street of play (flop,turn,river) and calculate percentage based on that
     */

}

package com.josephpark.pokerpal;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import org.w3c.dom.Text;

import static java.lang.Math.abs;

public class ExpectedValueCalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expected_value_calculator);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

    }

    public void calculateExpectedValue(View view){
        EditText potSize = findViewById(R.id.potSize);
        EditText betSize = findViewById(R.id.betSize);
        EditText winPercentage = findViewById(R.id.winPercentage);
        TextView EVText = findViewById(R.id.expectedValueAnswerText);
        double pot=0, bet=0, win=0;
        try {
            pot = Double.parseDouble(potSize.getText().toString());
            bet = Double.parseDouble(betSize.getText().toString());
            win = Double.parseDouble(winPercentage.getText().toString()) / 100;
        } catch (NumberFormatException e){
            Toast.makeText(getApplicationContext(), "Please input all values", Toast.LENGTH_LONG).show();
        } catch (Exception e){
            Toast.makeText(getApplicationContext(), "Exception: " + e, Toast.LENGTH_LONG).show();
        }
        // EV = (%W * $W) - (%L * $L)
        double EV = (win * pot) - ((1 - win) * bet);
        if (EV < 0)
            EVText.setText(String.format("-$%.2f", abs(EV)));
        else
            EVText.setText(String.format("$%.2f", EV));
    }
    /*TODO
    app crashes when calculating with some forms unfilled
        put in prefilled values
    for negative EV, put '-' in front of dollar sign like '-$1.00'
    for percentage of winning, choose between current percentage or
        have editText for number of outs and buttons for current street of play (flop,turn,river) and calculate percentage based on that

        make pressing back on menu have correct animation
     */

}

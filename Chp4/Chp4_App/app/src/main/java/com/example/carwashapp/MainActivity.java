package com.example.carwashapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double exteriorOnlyOver12 = 8.99;
    double exteriorVacuumOver12 = 12.99;
    double exteriorOnlyLess12 = 10.99;
    double exteriorVacuumLess12 = 15.99;
    int numberOfWashes;
    double packagePrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText washes = (EditText) findViewById(R.id.txtWashes);
        final RadioButton exteriorOnly = (RadioButton) findViewById(R.id.radExteriorOnly);
        final RadioButton exteriorVacuum = (RadioButton) findViewById(R.id.radExteriorVacuum);
        final TextView result = (TextView) findViewById(R.id.txtResult);
        Button calculate = (Button) findViewById(R.id.btnCalculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOfWashes = Integer.parseInt(washes.getText().toString());
                DecimalFormat hundredth = new DecimalFormat("#.##");
                if(exteriorOnly.isChecked()){
                    if(numberOfWashes >= 12){
                        packagePrice = exteriorOnlyOver12 * numberOfWashes;
                        result.setText("$" + hundredth.format(packagePrice) + " for " + numberOfWashes + " washes.");
                    } else {
                        packagePrice = exteriorOnlyLess12 * numberOfWashes;
                        result.setText("$" + hundredth.format(packagePrice) + " for " + numberOfWashes + " washes.");
                        Toast.makeText(MainActivity.this, "Buy more than 12 washes to receive a discount!", Toast.LENGTH_LONG).show();
                    }
                } else if(exteriorVacuum.isChecked()){
                    if(numberOfWashes >= 12){
                        packagePrice = exteriorVacuumOver12 * numberOfWashes;
                        result.setText("$" + hundredth.format(packagePrice) + " for " + numberOfWashes + " washes.");
                    } else {
                        packagePrice = exteriorVacuumLess12 * numberOfWashes;
                        result.setText("$" + hundredth.format(packagePrice) + " for " + numberOfWashes + " washes.");
                        Toast.makeText(MainActivity.this, "Buy more than 12 washes to receive a discount!", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
    }
}

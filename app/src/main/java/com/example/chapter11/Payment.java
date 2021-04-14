package com.example.chapter11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        TextView montlyPayment = (TextView)findViewById(R.id.txyMonthlyPay);
        ImageView img = (ImageView)findViewById(R.id.imgYears);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        int intYears = sharedPref.getInt("key1", 0);
        int intLoan = sharedPref.getInt("key2", 0);
        float decInterest = sharedPref.getFloat("key3", 0);
        float decMontlyPayment;

        decMontlyPayment = (intLoan * (1 + decInterest * intYears)) / (12 * intYears);
        DecimalFormat currency = new DecimalFormat("$###,###.##");
        montlyPayment.setText("Monthly Payment" +currency.format(decMontlyPayment));
        if (intYears == 3){
            img.setImageResource(R.drawable.three);
        }
        else if (intYears == 4){
            img.setImageResource(R.drawable.four);
        }
        else if (intYears == 5){
            img.setImageResource(R.drawable.five);
        }
        else {
            montlyPayment.setText("Enter 3, 4, or 5 years");
        }
    }
}
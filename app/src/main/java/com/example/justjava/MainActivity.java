package com.example.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int count, price;
    TextView countView, priceSummaryTV;
    Button summaryButton,addCountBtn, reduceCountBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        count = 0;
        countView = findViewById(R.id.countTextView);
        priceSummaryTV = findViewById(R.id.priceSummary);
        summaryButton = findViewById(R.id.summariseButton);
        addCountBtn = findViewById(R.id.addCountButton);
        reduceCountBtn = findViewById(R.id.deductCountButton);

        countView.setText(count);

        reduceCountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(count == 0){
                    reduceCountBtn.setActivated(false);
                    count = 0;
                    countView.setText(count);
                }else {

                    count -=1;
                    countView.setText(count);
                }
            }
        });

        addCountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               count +=1 ;
               countView.setText(count);

            }
        });

        summaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                price = 3* count;
                priceSummaryTV.setText("Total Cost: " + "$" + price  + "\n Thank You Come Again!!!" );
            }
        });

    }
}

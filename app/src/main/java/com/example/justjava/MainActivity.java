package com.example.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int quantity, price = 3, total;
    TextView countTV, priceSummaryTV;
    Button summaryButton, incrementButton, decrementButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quantity = 0;
        countTV = findViewById(R.id.quantity_count_text_view);
        priceSummaryTV = findViewById(R.id.price_summary_text_view);
        summaryButton = findViewById(R.id.summarise_button);
        incrementButton = findViewById(R.id.increment_button);
        decrementButton = findViewById(R.id.decrement_button);



        decrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    decrementQuantity();

            }
        });

        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               incrementQuantity();

            }
        });

        summaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total = price * quantity;
                priceSummaryTV.setText("Total Cost: " + "$" + total  + "\n Thank You Come Again!!!" );
            }
        });

    }

    public void incrementQuantity( ){
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    public void decrementQuantity(){
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    public void displayQuantity(int quantity){
        countTV.setText(String.valueOf(quantity));
    }
}

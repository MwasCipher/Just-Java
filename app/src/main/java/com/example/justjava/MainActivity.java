package com.example.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int quantity, price = 3, total;
    EditText nameEditText;
    TextView countTV, priceSummaryTV;
    Button summaryButton, incrementButton, decrementButton;
    CheckBox chocolateCheckBox, whippedCreamCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quantity = 1;

        nameEditText = findViewById(R.id.name_edit_text);

        countTV = findViewById(R.id.quantity_count_text_view);
        priceSummaryTV = findViewById(R.id.order_summary_text_view);
        summaryButton = findViewById(R.id.summarise_button);
        incrementButton = findViewById(R.id.increment_button);
        decrementButton = findViewById(R.id.decrement_button);

        chocolateCheckBox = findViewById(R.id.chocolate_check_box);
        whippedCreamCheckBox = findViewById(R.id.whipped_cream_check_box);


        countTV.setText(String.valueOf(quantity));


        decrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (quantity > 1) {

                    decrementQuantity();

                } else {
                    return;
                }


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

                submitOrder();
            }
        });

    }

    public void incrementQuantity() {
        if (quantity >= 1 && quantity <= 100) {
            quantity = quantity + 1;
            displayQuantity(quantity);
        }else {
            return;
        }
    }

    public void decrementQuantity() {
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    public void displayQuantity(int quantity) {
        countTV.setText(String.valueOf(quantity));
    }

    private String createOrderSummary() {

        String name = nameEditText.getText().toString().trim();
        String summaryMessage = " Name: " + name;

        if (whippedCreamCheckBox.isChecked()) {
            summaryMessage = summaryMessage + "\n Topped With Whipped Cream.... Yummy";

        }

        if (chocolateCheckBox.isChecked()) {
            summaryMessage = summaryMessage + "\n Topped  With  Chocolate.... Fabulous";

        }


        if (whippedCreamCheckBox.isChecked()) {
            price += 1;

        }

        if (chocolateCheckBox.isChecked()) {
            price += 3;
        }

        total = price * quantity;
        summaryMessage = summaryMessage + "\n Quantity: " + quantity;
        summaryMessage = summaryMessage + "\n Total Price: " + total;


        summaryMessage = summaryMessage + "\n Thank You And Come Again";


        return summaryMessage;
    }

    private void submitOrder() {
        String summaryMessage = createOrderSummary();
        priceSummaryTV.setText(summaryMessage);
    }

}

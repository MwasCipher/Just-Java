package com.example.justjava;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int quantity;
    EditText nameEditText;
    TextView countTV;
    Button summaryButton, incrementButton, decrementButton;
    CheckBox chocolateCheckBox, whippedCreamCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quantity = 1;

        nameEditText = findViewById(R.id.name_edit_text);

        countTV = findViewById(R.id.quantity_count_text_view);
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
        } else {

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

    private String createOrderSummary( String name, int price, boolean hasWhippedCream, boolean hasChocolate) {


        String summaryMessage = " Name: " + name;
        summaryMessage = summaryMessage + "\n Quantity: " + quantity;
        summaryMessage = summaryMessage + "\n Total Price: " + price;
        summaryMessage = summaryMessage + "\n Has Whipped Cream?: " + hasWhippedCream;
        summaryMessage = summaryMessage + "\n Has Chocolate?: " + hasChocolate;
        summaryMessage = summaryMessage + "\n Thank You And Come Again";

        return summaryMessage;
    }

    private int calculatePrice(boolean hasWhippedCream, boolean hasChocolate){

        int basePrice = 5;

         if (hasWhippedCream){
             basePrice +=2;
         }

         if (hasChocolate){
             basePrice +=4;
         }

        return quantity * basePrice;
    }

    public void submitOrder(){

        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        boolean hasChocolate = chocolateCheckBox.isChecked();

        int price = calculatePrice(hasWhippedCream, hasChocolate);

        String name = nameEditText.getText().toString().trim();
        String summaryMessage = createOrderSummary(name, price, hasWhippedCream, hasChocolate);


        Intent sendToEmail = new Intent(Intent.ACTION_SENDTO);

        sendToEmail.setData(Uri.parse("mailto: "));
        sendToEmail.putExtra(Intent.EXTRA_SUBJECT, "Just Java Order For " + name);
        sendToEmail.putExtra(Intent.EXTRA_TEXT, summaryMessage);

        if (sendToEmail.resolveActivity(getPackageManager()) != null) {
            startActivity(sendToEmail);
        }

    }

}

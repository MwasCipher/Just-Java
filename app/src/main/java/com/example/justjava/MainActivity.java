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

        quantity = 0;

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

                if (quantity > 0){

                    decrementQuantity();

                }else{
                    quantity = 0;
                    countTV.setText(String.valueOf(quantity));
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

    private String createOrderSummary(){

        total = price * quantity;
        String name = nameEditText.toString().trim();

        String summaryMessage = "Name: " + name;
        summaryMessage = summaryMessage + "\n Quantity: " + quantity;
        summaryMessage = summaryMessage + "\n Total Price: " + total;

        if (whippedCreamCheckBox.isChecked()){
            summaryMessage = summaryMessage + "\n Topped With Whipped Cream.... Yummy";
        }

        if (chocolateCheckBox.isChecked()){
            summaryMessage = summaryMessage + "\n Topped  With  Chocolate.... Fabulous";
        }


        summaryMessage = summaryMessage + "\nThank You And Come Again";



        return summaryMessage;
    }

    private void submitOrder(){
        String summaryMessage = createOrderSummary();
        priceSummaryTV.setText(summaryMessage);
    }

}

package com.example.sureshkumar.coffeeshop;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int quantity = 1;

    public int calculatePrice(boolean addhasWhite , boolean addhasChoco)
    {
        int price = 5 ;
        if (addhasWhite==true)
        {
            price= price+1;
        }
        if (addhasChoco==true)
        {
            price = price+2;
        }
        return quantity*price;
    }
    public int increment(View view)
    {
        if(quantity==50)
        {
            Context context= getApplicationContext();
            CharSequence text = "Sorry! You cannot have more than 50 coffee";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context,text,duration);
            toast.show();
            return 50;
        }
        quantity = quantity + 1;
        display(quantity);
        return 0;
    }
    public int decrement(View view)
    {
        if(quantity==1)
        {
            Context context= getApplicationContext();
            CharSequence text = "Sorry! You cannot have less than 1 coffee";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context,text,duration);
            toast.show();
            return 1;
        }
        quantity = quantity - 1;
        display(quantity);
        return 0;
    }

    public void display(int number)
    {


        TextView quantitytextview = (TextView)findViewById(R.id.quantity_text_view);
        quantitytextview.setText(""+number);
    }

    private void displayMessage(String message)
    {
        TextView priceTextView = (TextView) findViewById(R.id.submit_order);
        priceTextView.setText(message);
    }

    public void submitOrder(View view)

        {
            String quantityMessage = ordersummary(quantity);
            displayMessage(quantityMessage);

        }

    private String ordersummary(int number)
    {
        CheckBox WhiteCream = (CheckBox)findViewById(R.id.topping1) ;
        boolean hasWhite = WhiteCream.isChecked();
        CheckBox ChocoCream = (CheckBox)findViewById(R.id.topping2) ;
        boolean hasChoco = ChocoCream.isChecked();
        EditText Name = (EditText) findViewById(R.id.name_text);
        String nameText = Name.getText().toString();
        String msg = "Name:"+nameText+"\nQuantity:"+quantity +"\nHas WhiteCream :"+hasWhite+"\nHas ChocoCream :"+hasChoco+"\nTotal Price:"+calculatePrice(hasWhite, hasChoco);
        return msg;

    }


}



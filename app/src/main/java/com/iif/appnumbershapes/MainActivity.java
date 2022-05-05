package com.iif.appnumbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    class Number{

        int number;

        public boolean isSquare(){
            double squareRoot = Math.sqrt(number);

            if(squareRoot == Math.floor(squareRoot)){
                return true;
            }else {
                return false;
            }
        }
        public boolean isTriangular(){
            int x = 1;
            int triNumber = 1;

            while (triNumber < number){
                x++;
                triNumber = triNumber + x;
            }
            if(triNumber == number){
                return true;
            } else {
                return false;
            }
        }
    }

    public void clickFunction(View view) {
        EditText editText = (EditText) findViewById(R.id.editText);
        String message;

        if (editText.getText().toString().isEmpty()) {
            message = "enter a number";
        } else {

            Number myNumber = new Number();
            myNumber.number = Integer.parseInt(editText.getText().toString());

            if (myNumber.number < 0) {
                message = "enter a positive number";
            } else {

                if (myNumber.isSquare() && myNumber.isTriangular()) {
                    message = "both square and triangualar";
                } else if (myNumber.isTriangular()) {
                    message = "triangular number";
                } else if (myNumber.isSquare()) {
                    message = "square number";
                } else {
                    message = "Neither square nor triangular";
                }
            }
        }
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}
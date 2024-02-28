package com.example.demoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2, result;

    Button add;
    Button sub;
    Button mul;
    Button div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = (EditText) findViewById(R.id.number1);
        num2 = (EditText) findViewById(R.id.number2);
        result = (EditText) findViewById(R.id.res);

        add = findViewById(R.id.btn1);
        sub = findViewById(R.id.btn2);
        mul = findViewById(R.id.btn3);
        div = findViewById(R.id.btn4);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(String.valueOf(num1.getText()));
                int n2 = Integer.parseInt(String.valueOf(num2.getText()));
                int result = n1 + n2;

                Toast.makeText(MainActivity.this, "Result: " + result, Toast.LENGTH_LONG).show();
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(String.valueOf(num1.getText()));
                int n2 = Integer.parseInt(String.valueOf(num2.getText()));
                int result = n1 - n2;

                Toast.makeText(MainActivity.this, "Result: " + result, Toast.LENGTH_LONG).show();
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(String.valueOf(num1.getText()));
                int n2 = Integer.parseInt(String.valueOf(num2.getText()));
                int result = n1 * n2;

                Toast.makeText(MainActivity.this, "Result: " + result, Toast.LENGTH_LONG).show();
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(String.valueOf(num1.getText()));
                int n2 = Integer.parseInt(String.valueOf(num2.getText()));
                int result = n1 / n2;

                Toast.makeText(MainActivity.this, "Result: " + result, Toast.LENGTH_LONG).show();
            }
        });
    }
}
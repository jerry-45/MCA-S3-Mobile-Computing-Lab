package com.example.passing_data_between_activity;

//import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText1, editText2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.edit_text1);
        editText2 = findViewById(R.id.edit_text2);
        button = findViewById(R.id.button_submit);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String fname = editText1.getText().toString().trim();
                String lname = editText2.getText().toString().trim();

                if (fname.equals("") || lname.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                    intent.putExtra("FNAME",fname);
                    intent.putExtra("LNAME",lname);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
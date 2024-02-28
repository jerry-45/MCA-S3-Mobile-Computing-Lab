package com.example.registrationform;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etSurname, etFatherName, etEmail, etMobile, etAddress, etQualification, etPercentage, etHobbies;
    private RadioGroup rgGender;
    private RadioButton rbMale, rbFemale;
    private Button btnRegister;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etSurname = findViewById(R.id.etSurname);
        etFatherName = findViewById(R.id.etFatherName);
        etEmail = findViewById(R.id.etEmail);
        etMobile = findViewById(R.id.etMobile);
        etAddress = findViewById(R.id.etAddress);
        etQualification = findViewById(R.id.etQualification);
        etPercentage = findViewById(R.id.etPercentage);
        etHobbies = findViewById(R.id.etHobbies);
        rgGender = findViewById(R.id.rgGender);
        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        btnRegister = findViewById(R.id.btnRegister);

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                String surname = etSurname.getText().toString();
                String fatherName = etFatherName.getText().toString();
                String email = etEmail.getText().toString();
                String mobile = etMobile.getText().toString();
                String address = etAddress.getText().toString();
                String qualification = etQualification.getText().toString();
                String percentage = etPercentage.getText().toString();
                String hobbies = etHobbies.getText().toString();

                int selectedGenderId = rgGender.getCheckedRadioButtonId();
                String gender = "";
                if(selectedGenderId == R.id.rbMale)
                {
                    gender = "Male";
                }
                else if(selectedGenderId == R.id.rbFemale)
                {
                    gender = "Female";
                }

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name", name);
                editor.putString("surname", surname);
                editor.putString("fatherName", fatherName);
                editor.putString("email", email);
                editor.putString("mobile", mobile);
                editor.putString("address", address);
                editor.putString("qualification", qualification);
                editor.putString("percentage", percentage);
                editor.putString("hobbies", hobbies);
                editor.putString("gender", gender);
                editor.apply();

                startActivity(new Intent(MainActivity.this, StudentDetailActivity.class));
            }
        });
    }
}
package com.example.registrationform;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class StudentDetailActivity extends AppCompatActivity {

    TextView txtFullName, txtGender, txtEmailAddress, txtAddress, txtQualification, txtPercentage, txtHobbies;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        String name = sharedPreferences.getString("name", "");
        String fatherName = sharedPreferences.getString("fatherName", "");
        String surname = sharedPreferences.getString("surname", "");
        String gender = sharedPreferences.getString("gender", "");
        String email = sharedPreferences.getString("email", "");
        String address = sharedPreferences.getString("address", "");
        String qualification = sharedPreferences.getString("qualification", "");
        String percentage = sharedPreferences.getString("percentage", "");
        String hobbies = sharedPreferences.getString("hobbies", "");

        txtFullName = (TextView) findViewById(R.id.txtFullName);
        txtFullName.setText("Full Name: " + name + " " + fatherName + " " + surname);

        txtGender = (TextView) findViewById(R.id.txtGender);
        txtGender.setText("Gender: " + gender);

        txtEmailAddress = (TextView) findViewById(R.id.txtEmailAddress);
        txtEmailAddress.setText("Email Address: " + email);

        txtAddress = (TextView) findViewById(R.id.txtAddress);
        txtAddress.setText("Address: " + address);

        txtQualification = (TextView) findViewById(R.id.txtQualification);
        txtQualification.setText("Highest Qualification: " + qualification);

        txtPercentage = (TextView) findViewById(R.id.txtPercentage);
        txtPercentage.setText("Highest Qualification Percentage: " + percentage + "%");

        txtHobbies = (TextView) findViewById(R.id.txtHobbies);
        txtHobbies.setText("Hobbies: " + hobbies);
    }
}
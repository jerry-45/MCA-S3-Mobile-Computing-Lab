package com.example.sharedprefile;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.content.SharedPreferences;
import android.view.View;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button btnSave, btnRetrive, btnClear;
    EditText email,name;
    TextView nametxt, emailtxt;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnRetrive = (Button) findViewById(R.id.btnRetr);
        btnClear = (Button) findViewById(R.id.btnClear);

        email = (EditText) findViewById(R.id.etEmail);
        name = (EditText) findViewById(R.id.etName);

        nametxt = (TextView) findViewById(R.id.nametxt);
        emailtxt = (TextView) findViewById(R.id.emailtxt);

        sharedPreferences = getSharedPreferences("myPref", Context.MODE_PRIVATE);

        if(sharedPreferences.contains("nameKey"))
        {
            nametxt.setText(sharedPreferences.getString("nameKey", ""));
        }
        if(sharedPreferences.contains("emailKey"))
        {
            emailtxt.setText(sharedPreferences.getString("emailKey",""));
        }

    }

    public void save(View view)
    {
        String n = name.getText().toString();
        String e = email.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("nameKey", n);
        editor.putString("emailKey", e);
        editor.commit();
    }

    public void retrive(View view)
    {
        sharedPreferences = getSharedPreferences("myPref", Context.MODE_PRIVATE);
        if(sharedPreferences.contains("nameKey"))
        {
            nametxt.setText(sharedPreferences.getString("nameKey",""));
        }

        if(sharedPreferences.contains("emailKey"))
        {
            emailtxt.setText(sharedPreferences.getString("emailKey",""));
        }
    }

    public void clear(View view)
    {
        nametxt.setText("");
        emailtxt.setText("");
    }

}
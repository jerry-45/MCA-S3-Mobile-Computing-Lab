package com.example.internalstorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.Buffer;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    Button btnWrite, btnRead;
    String fileName = "myText";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);
        btnRead = (Button) findViewById(R.id.btnRead);
        btnWrite = (Button) findViewById(R.id.btnWrite);
    }

    public void writeBtnClick(View view){
        String name = editText.getText().toString();

        try{
            FileOutputStream fileOut = openFileOutput(fileName, MODE_PRIVATE);
            OutputStreamWriter outputWriter = new OutputStreamWriter(fileOut);
            outputWriter.write(name);
            outputWriter.close();
            editText.setText("");
            Toast.makeText(getApplicationContext(), "File Saved", Toast.LENGTH_LONG).show();
        }
        catch(Exception e)
        {

        }
    }

    public void readBtnClick(View view)
    {
        try
        {
            FileInputStream fileIn = openFileInput(fileName);
            InputStreamReader inoutRead = new InputStreamReader(fileIn);
            BufferedReader bufferedReader = new BufferedReader(inoutRead);
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            while((line = bufferedReader.readLine()) != null)
            {
                stringBuilder.append(line);
            }
            fileIn.close();
            inoutRead.close();
            Toast.makeText(getApplicationContext(), "File Read Successfully", Toast.LENGTH_LONG).show();
            textView.setText("Name: " + stringBuilder.toString());
        }
        catch(Exception e)
        {

        }
    }
}
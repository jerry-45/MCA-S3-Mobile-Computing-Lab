package com.atulv.json_parser;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.atulv.json_parser.beans.Company;
import com.atulv.json_parser.json.JsonWriterExample;
import com.atulv.json_parser.json.ReadJSONExample;

import java.io.StringWriter;

public class MainActivity extends AppCompatActivity {

    private EditText outputText;
    private Button btnRead, btnWrite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.outputText = (EditText)this.findViewById(R.id.editText);
        this.btnRead = (Button) this.findViewById(R.id.buttonRead);
        this.btnWrite = (Button) this.findViewById(R.id.buttonWrite);

        this.btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReadJson(view);
            }
        });

        this.btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WriteJson(view);
            }
        });
    }



    public void ReadJson(View view)  {
        try {
            Company company = ReadJSONExample.readCompanyJSONFile(this);
            outputText.setText(company.toString());
        }
        catch(Exception e)  {
            outputText.setText(e.getMessage());
            e.printStackTrace();
        }
    }

    public void WriteJson(View view){
        try{
            StringWriter output = new StringWriter();
            Company company = JsonWriterExample.createCompany();
            JsonWriterExample.writeJsonStream(output, company);
            String jsonText = output.toString();
            outputText.setText(jsonText);
        }
        catch (Exception e){
            outputText.setText(e.getMessage());
            e.printStackTrace();
        }
    }





//    public void runExample(View view)  {
//        try {
//            StringWriter output = new StringWriter();
//
//            Company company = JsonWriterExample.createCompany();
//
//
//            JsonWriterExample.writeJsonStream(output, company);
//
//            String jsonText = output.toString();
//
//            outputText.setText(jsonText);
//        } catch(Exception e)  {
//            outputText.setText(e.getMessage());
//            e.printStackTrace();
//        }
//    }


}

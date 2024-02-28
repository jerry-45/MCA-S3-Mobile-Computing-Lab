package com.example.passing_data_between_activity;

//import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textView1, textView2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView1 = findViewById(R.id.text_view1);
        textView2 = findViewById(R.id.text_view2);
        button = findViewById(R.id.button_back);
        Bundle bundle= getIntent().getExtras();
        assert bundle != null;
        String firstName= bundle.getString("FNAME");
        String lastName=bundle.getString("LNAME");
        textView1.setText("First Name: "+firstName);
        textView2.setText("Last Name: "+lastName);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SecondActivity.this,MainActivity.class);

                startActivity(intent);
                finish();
            }
        });
    }
}
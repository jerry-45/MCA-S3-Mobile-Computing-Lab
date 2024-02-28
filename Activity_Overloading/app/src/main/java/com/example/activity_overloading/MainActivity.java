package com.example.activity_overloading;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event){
        switch(keyCode){
            case KeyEvent.KEYCODE_DPAD_CENTER:
                Toast.makeText(getBaseContext(), "Center was clicked", Toast.LENGTH_LONG).show();
                break;

            case KeyEvent.KEYCODE_DPAD_LEFT:
                Toast.makeText(getBaseContext(), "Left arrow was clicked", Toast.LENGTH_LONG).show();
                break;

            case KeyEvent.KEYCODE_DPAD_UP_RIGHT:
                Toast.makeText(getBaseContext(), "Right arrow was clicked", Toast.LENGTH_LONG).show();
                break;

            case KeyEvent.KEYCODE_DPAD_UP:
                Toast.makeText(getBaseContext(), "Up arrow was clicked", Toast.LENGTH_LONG).show();
                break;

            case KeyEvent.KEYCODE_DPAD_DOWN:
                Toast.makeText(getBaseContext(), "Down arrow was clicked", Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }
}
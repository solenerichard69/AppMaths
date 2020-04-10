package com.example.premiertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
//import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Regle extends AppCompatActivity {
    private Button backbtr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regle);
        this.backbtr= (Button)findViewById(R.id.backbt);

        backbtr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
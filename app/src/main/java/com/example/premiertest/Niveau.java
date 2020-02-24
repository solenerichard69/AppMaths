package com.example.premiertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Niveau extends AppCompatActivity {

    private Button bn1;
    private Button backbt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niveau);

            this.bn1= (Button)findViewById(R.id.bn1);

            bn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent otherAct =new Intent(getApplicationContext(), N1.class);
                    startActivity(otherAct);
                    finish();
                }
            });

        this.backbt= (Button)findViewById(R.id.backbt);

        backbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherAct =new Intent(getApplicationContext(), MainActivity.class);
                startActivity(otherAct);
                finish();
            }
        });
    }
}

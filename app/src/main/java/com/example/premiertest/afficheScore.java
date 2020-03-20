package com.example.premiertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class afficheScore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiche_score);
        Intent intent = getIntent();
        if (intent != null){
            Integer ValScore = intent.getIntExtra("Valeur", 0);
            TextView textV = findViewById(R.id.AffS);
            textV.setText("ValScore"); // pb il faudrait enlever "" mais si je le fait ca fait crash

        }
    }
}

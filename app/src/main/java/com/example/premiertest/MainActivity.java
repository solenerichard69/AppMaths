package com.example.premiertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.CookieManager;

public class MainActivity extends AppCompatActivity {



    private Button bclav2;
    private Button goniveau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.bclav2= (Button)findViewById(R.id.bclav2);

        bclav2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherAct =new Intent(getApplicationContext(), clav2.class);
                startActivity(otherAct);
                finish();
            }
        });

        this.goniveau= (Button)findViewById(R.id.goniveau);

        goniveau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherAct2 =new Intent(getApplicationContext(), Niveau.class);
                startActivity(otherAct2);
                finish();
            }
        });


    }
}

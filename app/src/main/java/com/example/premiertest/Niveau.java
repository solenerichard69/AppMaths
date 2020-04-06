package com.example.premiertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Niveau extends AppCompatActivity {

    private Button bn1;
    private Button bn2;
    private Button backbtn;

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
                    // finish();
                    // j'enleve le finish ici. Tout simplement car c'est mieux : on laisse
                    // l'activité en arriere plan, comme ca si on ferme l'activité  N1, on revient a Niveau auto
                }
            });

        this.bn2= (Button)findViewById(R.id.bn2);

        bn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherAct =new Intent(getApplicationContext(), N2.class);
                startActivity(otherAct);
                // finish();
                // j'enleve le finish ici. Tout simplement car c'est mieux : on laisse
                // l'activité en arriere plan, comme ca si on ferme l'activité  N1, on revient a Niveau auto
            }
        });

        this.backbtn= (Button)findViewById(R.id.backbt);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherAct =new Intent(getApplicationContext(), MainActivity.class);
                startActivity(otherAct);
                finish();
            }
        });
    }
}

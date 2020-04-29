package com.example.premiertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class N2 extends AppCompatActivity {

    //INITIALISATION\\
    private Button backbtn2;
    private Button ba2;
    private Button bs2;
    private Button bm2;
    private Button bt2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n2);

        //BOUTON RETOUR\\
        this.backbtn2= (Button)findViewById(R.id.backbt);
        backbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 finish();
            }
        });

        //BOUTON ADD2\\
        this.ba2= (Button)findViewById(R.id.ba2);
        ba2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherAct1 =new Intent(getApplicationContext(), Add2.class);
                startActivity(otherAct1);
            }
        });

        //BOUTON SOUS2\\
        this.bs2= (Button)findViewById(R.id.bs2);
        bs2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherAct2 =new Intent(getApplicationContext(), Sous2.class);
                startActivity(otherAct2);
            }
        });


        //BOUTON MULT2\\
        this.bm2= (Button)findViewById(R.id.bm2);
        bm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // CHANGER TOUT1 EN TOUT2
                Intent otherAct2 =new Intent(getApplicationContext(), Mult2.class);
                startActivity(otherAct2);
            }
        });

        //BOUTON TOUT2\\
        this.bt2= (Button)findViewById(R.id.bt2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // CHANGER TOUT1 EN TOUT2
                Intent otherAct2 =new Intent(getApplicationContext(), Tout2.class);
                startActivity(otherAct2);
            }
        });
    }




}

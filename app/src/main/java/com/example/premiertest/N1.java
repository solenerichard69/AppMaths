package com.example.premiertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class N1 extends AppCompatActivity {
    private Button backbtn1;//Bouton retour
    private Button ba1;//Bouton d'acces aux additions
    private Button bs1;//Bouton d'acces aux soustractions
    private Button bm1;//Bouton d'acces aux multiplications
    private Button bt1;//Bouton d'acces à un mélange de tous les exercices


    //Cette activité sert d'interface entre les niveaux et les exercices. L'utilisateur va juste choisir un bouton pour pouvoir ensuite réellement
    //commencer son exercice

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Association au bon layout
        setContentView(R.layout.activity_n1);

        //BOUTON RETOUR\\
        this.backbtn1= (Button)findViewById(R.id.backbt);
        backbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();//Met fin à l'activité en cours
            }
        });

        //BOUTON ADDITIONS\\
        this.ba1= (Button)findViewById(R.id.ba1);
        ba1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherAct1 =new Intent(getApplicationContext(), Add1.class);
                //Début de l'activité Add1
                startActivity(otherAct1);
            }
        });

        //BOUTON SOUSTRACTION\\
        this.bs1= (Button)findViewById(R.id.bs1);
        bs1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherAct2 =new Intent(getApplicationContext(), Sous1.class);
                //Début de l'activité Sous1
                startActivity(otherAct2);
            }
        });

        //BOUTON MULTIPLICATION\\
        this.bm1= (Button)findViewById(R.id.bm1);
        bm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherAct2 =new Intent(getApplicationContext(), Mult1.class);
                //Début de l'activité Mult1
                startActivity(otherAct2);
            }
        });

        //BOUTON TOUT\\
        this.bt1= (Button)findViewById(R.id.bt1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherAct2 =new Intent(getApplicationContext(), Tout1.class);
                //Début de l'activité Tout1
                startActivity(otherAct2);
            }
        });
    }




}

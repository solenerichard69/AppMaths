package com.example.premiertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Affiche_score_N1 extends AppCompatActivity {

    private Button rejouer;     //Bouton permattant de rejouer directement sur le même niveau
    private Button rejouer2;    //Bouton permattant de rejouer dans un autre niveau

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //On associe l'activité à un layout
        setContentView(R.layout.activity_affiche_score__n1);
        //Récupération des données d'autre autre activité
        Intent intent = getIntent();
        if (intent != null){

            int vallscore=0;    //Initialisation
            int vallscoremax=0;     //Initialisation
            vallscore = intent.getIntExtra("Valeur", 0);//Récupération de la varibale porta,t le nom Valeur
            vallscoremax = intent.getIntExtra("ValeurScoremax", 0);//Récupération de la variable portant le nom ValeurMax
            TextView textV = findViewById(R.id.AffS);//Initialisation de la zone de texte
            textV.setText("Votre score : "+vallscore+" point(s) \nScore max : "+vallscoremax+" point(s)");//Affichage des scores

        }



        //BOUTON REJOUER POUR RESTER AU MEME NIVEAU
        this.rejouer= (Button)findViewById(R.id.rejouer);
        rejouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Récupération de l'activité
                Intent otherAct =new Intent(getApplicationContext(), N1.class);
                //Début de l'activité
                startActivity(otherAct);
                finish();
            }
        });

        //BOUTON REJOUER EN CHANGEANT DE NIVEAU
        this.rejouer2= (Button)findViewById(R.id.rejouer2);
        rejouer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Récupération de l'activité
                Intent otherAct =new Intent(getApplicationContext(), Niveau.class);
                //Début de l'activité
                startActivity(otherAct);
                finish();
            }
        });
    }
}

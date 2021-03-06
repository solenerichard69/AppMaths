package com.example.premiertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//Cette page affiche le score du joueur, qui vient de terminer un exercice du Niveau 3
//Elle affiche également le score maximal atteint pour un exercice en particulier

public class Affiche_score_N3 extends AppCompatActivity {

    private Button rejouer;
    private Button rejouer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiche_score__n3);
        Intent intent = getIntent();
        if (intent != null){

            int vallscore=0;
            int vallscoremax=0;
            vallscore = intent.getIntExtra("Valeur", 0);
            vallscoremax = intent.getIntExtra("ValeurScoremax", 0);
            TextView textV = findViewById(R.id.AffS);
            textV.setText("Votre score : "+vallscore+" point(s) \nScore max : "+vallscoremax+" point(s)");



        }



        //BOUTON REJOUER POUR RESTER AU MEME NIVEAU
        this.rejouer= (Button)findViewById(R.id.rejouer);
        rejouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // action effectuée quand on clique sur "back"
                Intent otherAct =new Intent(getApplicationContext(), N3.class);
                startActivity(otherAct);
                finish();
            }
        });

        //BOUTON REJOUER EN CHANGEANT DE NIVEAU
        this.rejouer2= (Button)findViewById(R.id.rejouer2);
        rejouer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherAct =new Intent(getApplicationContext(), Niveau.class);
                startActivity(otherAct);
                finish();
            }
        });
    }
}

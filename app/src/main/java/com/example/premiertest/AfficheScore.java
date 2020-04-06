package com.example.premiertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AfficheScore extends AppCompatActivity {
    private Button rejouer;
    private Button rejouer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiche_score);
        Intent intent = getIntent();
        if (intent != null){

            int vallscore=0;
            int vallscoremax=0;
            vallscore = intent.getIntExtra("Valeur", 0);
            vallscoremax = intent.getIntExtra("ValeurScoremax", 0);
            TextView textV = findViewById(R.id.AffS);
            textV.setText("Votre score est de : "+vallscore+" point(s) et le score max est de "+vallscoremax);



        }



        //Rester au niveau 1
        this.rejouer= (Button)findViewById(R.id.rejouer);
        rejouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // action effectuée quand on clique sur "back"
                // on ferme simplement l'activité. Si l'activité appelante n'était
                // pas fermée, on reviendra automatiquement dessus. Elle était en arriere-plan.
                finish();
            }
        });

        //Changer de niveau
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

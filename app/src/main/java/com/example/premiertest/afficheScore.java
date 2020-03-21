package com.example.premiertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class afficheScore extends AppCompatActivity {
    private Button rejouer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiche_score);
        Intent intent = getIntent();
        if (intent != null){

            int vallscore=0;
            vallscore = intent.getIntExtra("Valeur", 0);
            TextView textV = findViewById(R.id.AffS);
            textV.setText("Votre score est de : "+vallscore+" point(s)");

            /*Partie de Soso
            Integer ValScore = intent.getIntExtra("Valeur", 0);
            TextView textV = findViewById(R.id.AffS);
            textV.setText("ValScore"); // pb il faudrait enlever "" mais si je le fait ca fait crash
            */
        }



        // *********************************//
        // mise en place du bouton "rejouer"
        // *********************************//

        this.rejouer= (Button)findViewById(R.id.rejouer);
        rejouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // action effectuée quand on clique sur "back"
                // on ferme simplement l'activité. Si l'activité appelante n'était
                // pas fermée, on reviendra automatiquement dessus. Elle était en arriere-plan.
                finish();
            }
        });
    }
}

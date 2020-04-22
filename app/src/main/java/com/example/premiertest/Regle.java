package com.example.premiertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
//import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Regle extends AppCompatActivity {
    private Button backbtr;//Bouton de retour

    //Cette activité est vitrine : elle permet juste d'afficher les régles du jeu, et de revenir en arriére

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regle);

        //BOUTON RETOUR\\
        this.backbtr= (Button)findViewById(R.id.backbt);
        backbtr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });//Fermeture de l'activité
    }
}
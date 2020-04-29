package com.example.premiertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;


//Cette activité correspond à la page d'accueil de notre application, c'est la premiere chose qui apparait lorsqu'on ouvre celle-ci
//C'est l'interface qui permet vraiement de démarrer le jeu

public class MainActivity extends AppCompatActivity {

    private Button regle; // button pour avoir accès aux règles
    private Button goniveau; // boutton d'accès aux niveaux pour commencer à jouer
    private MediaPlayer player; //élement qui permet de mettre en place le son


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE); // permet de supprimer le titre qui peut apparaitre en haut du main
        super.onCreate(savedInstanceState);
        //Associe le layout à son activité
        setContentView(R.layout.activity_main);

        //BOUTON REGLES DU JEU\\
        this.regle= (Button)findViewById(R.id.bregle);
        regle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Des que le joueur clique sur Régles du jeu, une fenetre apparait, c'est le début de la nouvelle activité
                Intent otherAct =new Intent(getApplicationContext(), Regle.class);
                startActivity(otherAct);
            }
        });

        //BOUTON JOUER\\
        this.goniveau= (Button)findViewById(R.id.goniveau);
        goniveau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Des que le joueur clique sur JOUER, une fenetre apparait, c'est le début de la nouvelle activité
                Intent otherAct2 =new Intent(getApplicationContext(), Niveau.class);
                startActivity(otherAct2);
            }
        });

        //MISE EN PLACE DE LA MUSIQUE\\
        this.player = MediaPlayer.create(getApplicationContext(), R.raw.son_app);
        //On lance la musique dès que l'activité est créee
        player.start();

        //Bouton Cutson, avec deux valeurs possibles On et Off
        ToggleButton cutson = (ToggleButton) findViewById(R.id.cutson);
        cutson.setTextOn("  ");
        cutson.setTextOff("  ");

        //Action de l'utilisateur sur le bouton Cutson
        cutson.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //Le bouton est en mode cliqué, la musique est mise sur pause
                if (isChecked) {
                    player.pause();
                } else {
                    //Sinon le musique reprend normalement
                    player.start();
                }
            }
        });


    }


    public void onCustomToggleClick(View view) {


    }
}

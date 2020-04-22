package com.example.premiertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Niveau extends AppCompatActivity {

    private Button bn1;//Bouton d'acces au premier niveau
    private Button bn2;//Bouton d'acces au deuxieme niveau
    private Button bn3;//Bouton d'acces au troisième niveau
    private Button backbtn;//Bouton de retour

    //Cette activité permet à l'utilisateur de faire son choix entre les 3 niveaux.
    //Il a juste à cliquer sur l'un des 3 boutons, le bouton retour permet de revenir à la page d'accueil

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Association avec le bon layout
        setContentView(R.layout.activity_niveau);

            //BOUTON NIVEAU 1\\
        this.bn1= (Button)findViewById(R.id.bn1);
            bn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent otherAct =new Intent(getApplicationContext(), N1.class);
                    startActivity(otherAct);
                    //On laisse l'activité en arriere plan, comme ca si on ferme l'activité  N1, on revient a Niveau automatiquement
                }
            });


        //BOUTON NIVEAU 2\\
        this.bn2= (Button)findViewById(R.id.bn2);
        bn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherAct =new Intent(getApplicationContext(), N2.class);
                startActivity(otherAct);
                //On laisse l'activité en arriere plan, comme ca si on ferme l'activité  N2, on revient a Niveau automatiquement
            }
        });

        //BOUTON NIVEAU 3\\
        this.bn3= (Button)findViewById(R.id.bn3);
        bn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherAct =new Intent(getApplicationContext(), N3.class);
                startActivity(otherAct);
                //On laisse l'activité en arriere plan, comme ca si on ferme l'activité  N3, on revient a Niveau automatiquement
            }
        });

        //BOUTON RETOUR\\
        this.backbtn= (Button)findViewById(R.id.backbt);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });//On ferme l'activité
    }
}

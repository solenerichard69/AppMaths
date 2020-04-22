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


public class MainActivity extends AppCompatActivity {



    private Button regle; // button pour avoir accès aux règles
    private Button goniveau; // boutton d'accès aux niveaux pour commencer à jouer
    private MediaPlayer player;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE); // permet de supprimer le titre qui peut apparaitre en haut du main
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.regle= (Button)findViewById(R.id.bregle);

        regle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherAct =new Intent(getApplicationContext(), Regle.class);
                startActivity(otherAct);
            }
        });

        this.goniveau= (Button)findViewById(R.id.goniveau);

        goniveau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherAct2 =new Intent(getApplicationContext(), Niveau.class);
                startActivity(otherAct2);
            }
        });

        this.player = MediaPlayer.create(getApplicationContext(), R.raw.son_app);
       player.start();



        ToggleButton cutson = (ToggleButton) findViewById(R.id.cutson);
        cutson.setTextOn("  ");
        cutson.setTextOff("  ");

        cutson.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    player.pause();
                } else {
                    player.start();
                }
            }
        });


    }




    public void onCustomToggleClick(View view) {


    }
}

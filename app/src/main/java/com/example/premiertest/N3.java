package com.example.premiertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class N3 extends AppCompatActivity {

    //INITIALISATION\\
    private Button backbtn2;
    private Button ba2;
    private Button bs2;
    private Button bm2;
    private Button bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n3);

        //BOUTON RETOUR\\
        this.backbtn2= (Button)findViewById(R.id.backbt);
        backbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherAct1 =new Intent(getApplicationContext(), Niveau.class);
                //Retour au niveau
                startActivity(otherAct1);
            }
        });

        //BOUTON ADD3\\
        this.ba2= (Button)findViewById(R.id.ba2);
        ba2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherAct1 =new Intent(getApplicationContext(), Add3.class);
                startActivity(otherAct1);
        // finish(); (voir Niveau)
            }
        });

        //BOUTON SOUS3\\
        this.bs2= (Button)findViewById(R.id.bs2);
        bs2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // CHANGER SOUS1 EN SOUS2
                Intent otherAct2 =new Intent(getApplicationContext(), Sous3.class);
                startActivity(otherAct2);

                finish();
            }
        });

        //BOUTON MULT3\\
        this.bm2= (Button)findViewById(R.id.bm2);
        bm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // CHANGER TOUT1 EN TOUT2
                Intent otherAct2 =new Intent(getApplicationContext(), Mult3.class);
                startActivity(otherAct2);

                finish();
            }
        });


        //BOUTON TOUT3\\
        this.bt2= (Button)findViewById(R.id.bt2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // CHANGER TOUT1 EN TOUT2
                Intent otherAct2 =new Intent(getApplicationContext(), Tout3.class);
                startActivity(otherAct2);

                finish();
            }
        });
    }
}

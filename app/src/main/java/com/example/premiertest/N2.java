package com.example.premiertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class N2 extends AppCompatActivity {
    private Button backbtn2;
    private Button ba2;
    private Button bs2;
    private Button bm2;
    private Button bt2;
    public static boolean goChrono;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n2);
        this.backbtn2= (Button)findViewById(R.id.backbt);

        backbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherAct =new Intent(getApplicationContext(), Niveau.class);
                startActivity(otherAct);
                // finish(); (voir Niveau)
            }
        });
        this.ba2= (Button)findViewById(R.id.ba2);

        ba2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherAct1 =new Intent(getApplicationContext(), Add2.class);
                startActivity(otherAct1);
// finish(); (voir Niveau)
            }
        });


        this.bs2= (Button)findViewById(R.id.bs2);

        bs2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // CHANGER SOUS1 EN SOUS2
                Intent otherAct2 =new Intent(getApplicationContext(), Sous1.class);
                startActivity(otherAct2);

                finish();
            }
        });


        this.bm2= (Button)findViewById(R.id.bm2);

        bm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // CHANGER TOUT1 EN TOUT2
                Intent otherAct2 =new Intent(getApplicationContext(), Mult1.class);
                startActivity(otherAct2);

                finish();
            }
        });

        this.bt2= (Button)findViewById(R.id.bt2);

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // CHANGER TOUT1 EN TOUT2
                Intent otherAct2 =new Intent(getApplicationContext(), Tout1.class);
                startActivity(otherAct2);

                finish();
            }
        });
    }




}

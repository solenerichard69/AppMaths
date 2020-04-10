package com.example.premiertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class N1 extends AppCompatActivity {
    private Button backbtn1;
    private Button ba1;
    private Button bs1;
    private Button bm1;
    private Button bt1;
   public static boolean goChrono;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n1);
        this.backbtn1= (Button)findViewById(R.id.backbt);

        backbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        this.ba1= (Button)findViewById(R.id.ba1);

        ba1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherAct1 =new Intent(getApplicationContext(), Add1.class);
                startActivity(otherAct1);
            }
        });


        this.bs1= (Button)findViewById(R.id.bs1);

        bs1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherAct2 =new Intent(getApplicationContext(), Sous1.class);
                startActivity(otherAct2);
            }
        });


        this.bm1= (Button)findViewById(R.id.bm1);

        bm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherAct2 =new Intent(getApplicationContext(), Mult1.class);
                startActivity(otherAct2);
            }
        });

        this.bt1= (Button)findViewById(R.id.bt1);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherAct2 =new Intent(getApplicationContext(), Tout1.class);
                startActivity(otherAct2);
            }
        });
    }




}

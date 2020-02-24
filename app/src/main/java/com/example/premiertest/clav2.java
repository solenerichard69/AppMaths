package com.example.premiertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
//import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class clav2 extends AppCompatActivity {
    private Button backbt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_clav2);

        this.backbt= (Button)findViewById(R.id.backbt);

        backbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherAct =new Intent(getApplicationContext(), MainActivity.class);
                startActivity(otherAct);
                finish();
            }
        });

       Integer a=0;
       Integer b=0;

       a=1 + (int) (Math.random()*(100));
       b=1 + (int) (Math.random()*(100));

        TextView calcul = (TextView) findViewById(R.id.calcul);
        calcul.setText(""+a+"+"+b+"=");

    }
}

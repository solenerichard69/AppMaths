package com.example.premiertest;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class Add1 extends AppCompatActivity {
    Integer sucess=0;
    Integer score=0;
    private Button backbt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add1);
        this.backbt= (Button)findViewById(R.id.backbt);

        backbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherAct =new Intent(getApplicationContext(), Niveau.class);
                startActivity(otherAct);
                finish();
            }
        });
        //Mise en place de l'affichage du calcul

        Integer a = 0;
        Integer b = 0;

        a = 1 + (int) (Math.random() * (100));
        b = 1 + (int) (Math.random() * (100));

        TextView test = (TextView) findViewById(R.id.test);
        test.setText(""+a+" + "+b+" =  ?");
        Integer result = a+b; //Calcul du résultat attendu
        Integer nb=a; //Test de résultat

        // EditText remplir = (EditText) findViewById(R.id.remplir);


        //A METTRE UNE FOIS QUE LE EDIT TEXT EST REMPLI
        Verification(result,nb);
        CalculScore(sucess);

        TextView affichagescore = (TextView) findViewById(R.id.affichagescore);
        affichagescore.setText("Score : "+score);




    }

    public void CalculScore (int sucess){
        score=+sucess;
    }

    public void Verification(int result, int result2){
        if(result==result2){
            sucess++;

            TextView resultat = (TextView) findViewById(R.id.resultat);
            resultat.setText("Bien joué !!!");
        }else
        {
            TextView resultat = (TextView) findViewById(R.id.resultat);
            resultat.setText("Dommage !");
        }

    }
    }


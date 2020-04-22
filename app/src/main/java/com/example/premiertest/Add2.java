package com.example.premiertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Add2 extends AppCompatActivity {
    public int counter = 30;
    Integer sucess=0;
    Integer score=0;
    Integer result;
    Integer result1;
    Integer triche=0;
    TextView chrono;
    private Button backbta1;
    Button ok;
    Integer pastriche=1;
    Integer scoremax=0;
    CountDownTimer monCompteARebours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add2);
        //BOUTON RETOUR
        this.backbta1= (Button)findViewById(R.id.backbt);
        backbta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                monCompteARebours.cancel();
                finish();
            }
        });



        //MISE EN PLACE DU CHRONOMETRE
        this.chrono= (TextView) findViewById(R.id.chrono);
        CountDownTimer monCompteARebours =  new  CountDownTimer(counter*1000, 1000){

            public void onTick (long millisUntilFinish){
                counter--; // on diminue le temps restant
                chrono.setText("\n                 "+counter+"");
            }

            public void onFinish(){
                ScoreMax(score);
                int ValScore = score;
                int ValScoremax =scoremax;
                Intent otherAct =new Intent(getApplicationContext(), Affiche_score_N2.class);
                otherAct.putExtra("Valeur", ValScore);
                otherAct.putExtra("ValeurScoremax", ValScoremax);
                startActivity(otherAct);
                finish();
            }
        };

        //MISE EN MEMOIRE DU SCORE
        SharedPreferences mesprefsEnregistrees = PreferenceManager.getDefaultSharedPreferences(this);
        scoremax = mesprefsEnregistrees.getInt("meilleurScore14", 0);
        monCompteARebours.start();

        Integer a = 0;
        Integer b = 0;

        //MISE EN PLACE DU CALCUL
        a = 1 + (int) (Math.random() * (50));
        b = 1 + (int) (Math.random() * (50));


        TextView test = (TextView) findViewById(R.id.test);
        test.setText(+a+" + "+b+" =");
        result = a+b; //Calcul du résultat attendu

        //BOUTON OK
        ok = findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText remplir = (EditText)findViewById(R.id.remplir);

                int nb = 0;
                try {
                    nb = (int) Integer.parseInt(remplir.getText().toString());
                }
                catch (Exception e) {
                }
                boolean resultoperation = Verification(result,nb);
                CalculScore(sucess);


                if (resultoperation == true) {

                    int c = 1 + (int) (Math.random() * (50));
                    int d = 1 + (int) (Math.random() * (50));
                    TextView test = (TextView) findViewById(R.id.test);
                    test.setText(+c+" + "+d+" =");

                    result = c+d; //Calcul du résultat attendu
                }

                TextView affichagescore = (TextView) findViewById(R.id.affichagescore);
                affichagescore.setText("Score : "+score);
                remplir.getText().clear();

            }
        });



    }

    //CALCUL DU SCORE
    public void CalculScore (int sucess){
        score=+sucess;
    }

    //VERIFICATION DU RESULTAT
    public boolean Verification(int result, int result2){
        if(result==result2){
            sucess++;
            triche =1;
            pastriche=0;
        }else
        {
            triche =0;
            pastriche=1;

        }
        return (result==result2);
    }

    //COMPARAISON AVEC LE SCORE MAX
    public void ScoreMax(int scoreencours){
        if(scoreencours>=scoremax){
            scoremax=scoreencours;

            SharedPreferences meilleurScore = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = meilleurScore.edit();
            editor.putInt("meilleurScore14", scoremax);
            editor.commit();
        }
    }


}


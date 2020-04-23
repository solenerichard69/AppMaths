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

public class Add3 extends AppCompatActivity {
    public int counter = 30; // temps de countdown en secondes
    Integer sucess=0;
    Integer score=0;
    Integer result;
    Integer result1;
    TextView chrono;
    private Button backbta1;
    Button ok;
    Integer scoremax=0;
    CountDownTimer monCompteARebours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add3);

        this.backbta1= (Button)findViewById(R.id.backbt);

        backbta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                monCompteARebours.cancel();
                finish();
            }
        });

        //COMPTE A REBOURS
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
                Intent otherAct =new Intent(getApplicationContext(), Affiche_score_N3.class); //Méne à l'activité N3 qui affiche le score
                otherAct.putExtra("Valeur", ValScore);
                otherAct.putExtra("ValeurScoremax", ValScoremax);
                startActivity(otherAct);
                finish();
            }
        };

        //MISE EN MEMOIRE
        SharedPreferences mesprefsEnregistrees = PreferenceManager.getDefaultSharedPreferences(this);
        scoremax = mesprefsEnregistrees.getInt("meilleurScore10", 0);

        monCompteARebours.start();

        //MISE EN PLACE DU CALCUL
        Integer a = 0;
        Integer b = 0;

            a = 1 + (int) (Math.random() * (100));
            b = 1 + (int) (Math.random() * (100));


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

                    int c = 1 + (int) (Math.random() * (100));
                    int d = 1 + (int) (Math.random() * (100));
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
        }
        return (result==result2);
    }

    //SCORE MAX COMPARAISON AVEC LE SCORE EN COURS
    public void ScoreMax(int scoreencours){
        if(scoreencours>=scoremax){
            scoremax=scoreencours;

            SharedPreferences meilleurScore = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = meilleurScore.edit();
            editor.putInt("meilleurScore10", scoremax);
            editor.commit();
        }
    }


}


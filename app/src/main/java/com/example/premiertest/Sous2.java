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

public class Sous2 extends AppCompatActivity {

    //INITIALISATION\\
    public int counter = 30; // temps de countdown en secondes
    Integer sucess=0;
    Integer score=0;
    Integer result;
    Integer result1;
    TextView chrono; // déclaration du textview chrono présent dans layout
    private Button backbts1;
    Button ok;
    Integer scoremax=0;
    CountDownTimer monCompteARebours;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sous2);

        //BOUTON RETOUR\\
        this.backbts1= (Button)findViewById(R.id.backbt);

        backbts1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                monCompteARebours.cancel();
                finish();
            }
        });


        //CHRONOMETRE\\
        this.chrono= (TextView) findViewById(R.id.chrono);

        // on définit un nouveau compte à rebours : objet CountDownTimer
        // on lui passe en parametre le nombre de seconde (counter) et le délai entre chaque tic (1s)
        CountDownTimer monCompteARebours =  new  CountDownTimer(counter*1000, 1000){
            // on redéfinit la méthode onTick : que fait-t'on à chaque seconde décrémentée?
            public void onTick (long millisUntilFinish){
                counter--; // on diminue le temps restant
                chrono.setText("\n                 "+counter+""); // on met a jour l'affichage sur l'activité
            }

            // on redéfinit la méthode onFinish : que fait-t'on à la fin du compte à rebours?
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

        //MISE EN MEMOIRE\\
        SharedPreferences mesprefsEnregistrees = PreferenceManager.getDefaultSharedPreferences(this);
        scoremax = mesprefsEnregistrees.getInt("meilleurScore6", 0);

        //COMPTE A REBOUR\\
        monCompteARebours.start();

        //MISE EN PLACE DU CALCUL\\
        Integer a = 0;
        Integer b = 0;

        do{
            a = 1 + (int) (Math.random() * (50));
            b = 1 + (int) (Math.random() * (50));
        }while(b>=a);


        //AFFICHAGE DU CALCUL\\
        TextView test = (TextView) findViewById(R.id.test);
        test.setText(+a+" - "+b+" =");
        result = a-b; //Calcul du résultat attendu

        //BOUTON OKAY\\
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

                    // generation d'une nouvelle ligne

                    int c=0;
                    int d=0;
                    do{
                        c = 1 + (int) (Math.random() * (50));
                        d = 1 + (int) (Math.random() * (50));
                    }while(d>=c);
                    TextView test = (TextView) findViewById(R.id.test);
                    test.setText(+c+" - "+d+" =");

                    result = c-d; //Calcul du résultat attendu



                }

                TextView affichagescore = (TextView) findViewById(R.id.affichagescore);
                affichagescore.setText("Score : "+score);
                remplir.getText().clear();

            }
        });



    }
    //CALCUL DU SCORE\\
    public void CalculScore (int sucess){
        score=+sucess;
    }

    //VERIFICATION\\
    public boolean Verification(int result, int result2){
        if(result==result2){
            sucess++;
        }
        return (result==result2);
    }

    //CALCUL DU SCORE MAXIMAL\\
    public void ScoreMax(int scoreencours){
        if(scoreencours>=scoremax){
            scoremax=scoreencours;

            SharedPreferences meilleurScore = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = meilleurScore.edit();
            editor.putInt("meilleurScore6", scoremax);
            editor.commit();


        }
    }

}

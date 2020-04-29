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

public class Sous1 extends AppCompatActivity {

    //INITIALISATION\\
    public int counter = 30;
    Integer sucess=0;
    Integer score=0;
    Integer result;
    Integer result1;
    TextView chrono;
    private Button backbts1;
    Button ok;
    Integer scoremax1=0;
    CountDownTimer monCompteARebours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sous1);

        //BOUTON RETOUR\\
        this.backbts1= (Button)findViewById(R.id.backbt);
        backbts1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                monCompteARebours.cancel();
                finish();
            }
        });


        //MISE EN PLACE DU CHRONOMETRE\\
        this.chrono= (TextView) findViewById(R.id.chrono);
         monCompteARebours =  new  CountDownTimer(counter*1000, 1000){
            public void onTick (long millisUntilFinish){
                counter--; // on diminue le temps restant
                chrono.setText("\n                 "+counter+"");
            }

            // on redéfinit la méthode onFinish : que fait-t'on à la fin du compte à rebours?
            public void onFinish(){
                ScoreMax(score);
                int ValScore = score;
                int ValScoremax1 =scoremax1;
                Intent otherAct =new Intent(getApplicationContext(), Affiche_score_N1.class);
                otherAct.putExtra("Valeur", ValScore);
                otherAct.putExtra("ValeurScoremax", ValScoremax1);
                startActivity(otherAct);
                finish();
            }
        };


         //MISE EN MEMOIRE DU SCORE\\
        SharedPreferences mesprefsEnregistrees = PreferenceManager.getDefaultSharedPreferences(this);
        scoremax1 = mesprefsEnregistrees.getInt("meilleurScore00", 0);


         // on lance le compte a rebours :
        monCompteARebours.start();

        //MISE EN PALCE DU CALCUL\\
        Integer a = 0;
        Integer b = 0;

        do{
            a = 1 + (int) (Math.random() * (15));
            b = 1 + (int) (Math.random() * (15));
        }while(b>=a) ; //On fait en sorte de toujours avoir un résultat positif dans le choix des variables


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
                        c = 1 + (int) (Math.random() * (15));
                        d = 1 + (int) (Math.random() * (15));
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

    //VERIFICATION DU SCORE\\
    public boolean Verification(int result, int result2){
        if(result==result2){
            sucess++;
        }
        return (result==result2);
    }

    //CALCUL DU SCORE MAX\\
    public void ScoreMax(int scoreencours){
        if(scoreencours>=scoremax1){
            scoremax1=scoreencours;

            SharedPreferences meilleurScore = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = meilleurScore.edit();
            editor.putInt("meilleurScore00", scoremax1);
            editor.commit();


        }
    }
}

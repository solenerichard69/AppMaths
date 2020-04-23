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

public class Tout2 extends AppCompatActivity {

    public int counter = 30; // temps de countdown en secondes
    Integer sucess=0;
    Integer score=0;
    Integer result;
    Integer result1;
    TextView chrono; // déclaration du textview chrono présent dans layout
    private Button backbtt2;
    Button ok;
    Integer scoremax=0;
    CountDownTimer monCompteARebours;

    // la méthode onCreate() est appelée à la création de l'activité
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // on associe l'acticité au layout du meme nom
        setContentView(R.layout.activity_tout2);

        this.backbtt2= (Button)findViewById(R.id.backbt);
        backbtt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                monCompteARebours.cancel();
                finish();
            }
        });

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

        SharedPreferences mesprefsEnregistrees = PreferenceManager.getDefaultSharedPreferences(this);
        scoremax = mesprefsEnregistrees.getInt("meilleurScore7", 0);


        monCompteARebours.start();

        //Mise en place de l'affichage du calcul
        Integer a = 0;
        Integer b = 0;
        Integer e = 0;

        e = 1 + (int) (Math.random() * (3));
        do{
            a = 1 + (int) (Math.random() * (30));
            b = 1 + (int) (Math.random() * (30));
        }while(b>a);



        if(e==1){
            TextView test = (TextView) findViewById(R.id.test);
            test.setText(+a+" + "+b+" =");
            result = a+b; //Calcul du résultat attendu
        }
        if(e==2){
            TextView test = (TextView) findViewById(R.id.test);
            test.setText(+a+" - "+b+" =");
            result = a-b; //Calcul du résultat attendu
        }else
        if(e==3){
            TextView test = (TextView) findViewById(R.id.test);
            test.setText(+a+" * "+b+" =");
            result = a*b; //Calcul du résultat attendu
        }


        //Récupére la valeur d'édit text et la vérifie
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
                    int e=0;
                    e = 1 + (int) (Math.random() * (3));
                    do{
                        c = 1 + (int) (Math.random() * (30));
                        d = 1 + (int) (Math.random() * (30));
                    }while(d>c);



                    if(e==1){
                        TextView test = (TextView) findViewById(R.id.test);
                        test.setText(+c+" + "+d+" =");
                        result = c+d; //Calcul du résultat attendu
                    }
                    if(e==2){
                        TextView test = (TextView) findViewById(R.id.test);
                        test.setText(+c+" - "+d+" =");
                        result = c-d; //Calcul du résultat attendu
                    }else
                    if(e==3){
                        TextView test = (TextView) findViewById(R.id.test);
                        test.setText(+c+" * "+d+" =");
                        result = c*d; //Calcul du résultat attendu
                    }

                }

                TextView affichagescore = (TextView) findViewById(R.id.affichagescore);
                affichagescore.setText("Score : "+score);
                remplir.getText().clear();

            }
        });




    }
    public void CalculScore (int sucess){
        score=+sucess;
    }

    public boolean Verification(int result, int result2){
        if(result==result2){
            sucess++;
        }
        return (result==result2);
    }

    public void ScoreMax(int scoreencours){
        if(scoreencours>=scoremax){
            scoremax=scoreencours;

            System.out.println("[debug] on enregistre le novueau score max du tel"+ scoremax);

            SharedPreferences meilleurScore = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = meilleurScore.edit();
            editor.putInt("meilleurScore7", scoremax);
            editor.commit();
        }
    }
}
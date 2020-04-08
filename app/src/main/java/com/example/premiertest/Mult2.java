package com.example.premiertest;
import androidx.annotation.Nullable;
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

public class Mult2 extends AppCompatActivity {
    public int counter = 30; // temps de countdown en secondes
    Integer sucess=0;
    Integer score=0;
    Integer result;
    Integer result1;
    Integer cpt=1;
    Integer triche=0;
    TextView chrono; // déclaration du textview chrono présent dans layout
    private Button backbta1;
    Button ok;
    Button suivant;
    Integer pastriche=1;
    Integer scoremax=0;

    // la méthode onCreate() est appelée à la création de l'activité
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // on associe l'acticité au layout du meme nom
        setContentView(R.layout.activity_mult2);
        /* cette activité comporte :
        - un textview nommé chrono
        - un bouton nommé backbt (pour revenir en arriere )
        ...
         */

        // *********************************//
        // mise en place du bouton "retour"
        // *********************************//

        // on lie le bouton backbt avec l'attribut de classe backbta1
        this.backbta1= (Button)findViewById(R.id.backbt);

        backbta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // action effectuée quand on clique sur "back"
                // on ferme simplement l'activité. Si l'activité appelante  (ici Niveau.class) n'était
                // pas fermée, on reviendra automatiquement dessus. Elle était en arriere-plan.
                finish();
            }
        });

        // *********************************//
        // mise en place du chronometre
        // *********************************//

        // chrono le textview de l'activite sera utilisé pour afficher le chronometre
        // On lie chrono l'attribut, avec chrono le textview du layout.
        // on affichera la valeur du chronometre à l'interieur de chrono
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

        // *********************************//
        // chargement de l'ancien score"
        // *********************************//

        SharedPreferences mesprefsEnregistrees = PreferenceManager.getDefaultSharedPreferences(this);
        scoremax = mesprefsEnregistrees.getInt("meilleurScore5", 0);

        System.out.println("[debug] on charge le score max du tel"+ scoremax);
        // on lance le compte a rebours :

        monCompteARebours.start();

        // *********************************//
        // reste du code
        // *********************************//

        //Mise en place de l'affichage du calcul
        Integer a = 0;
        Integer b = 0;


        a = 1 + (int) (Math.random() * (20));
        b = 1 + (int) (Math.random() * (20));


        TextView test = (TextView) findViewById(R.id.test);
        test.setText("                         "+a+" * "+b+" =");
        result = a*b; //Calcul du résultat attendu

       // TextView cpta = (TextView) findViewById(R.id.cpta);
       // cpta.setText(""+cpt+" / 20");



        //Récupére la valeur d'édit text et la vérifie
        ok = findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText remplir = (EditText)findViewById(R.id.remplir);

                int nb = 0;
                TextView resultat = (TextView) findViewById(R.id.resultat);
                try {
                    nb = (int) Integer.parseInt(remplir.getText().toString());
                }
                catch (Exception e) { // si ca merde car rien saisi oui texte pas un entier
                    resultat.setText("ERREUR");
                }

                Verification(result,nb);
                CalculScore(sucess);

                TextView affichagescore = (TextView) findViewById(R.id.affichagescore);
                affichagescore.setText("Score : "+score);
                remplir.getText().clear();


                //Fonction pour ne pas tricher
                if(triche ==1){
                    ok.setClickable(false);
                }else
                if(triche==0){
                    ok.setClickable(true);
                }


            }
        });


        suivant = findViewById(R.id.suivant);
        suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                triche=0;
                //Anti triche
                /*if(pastriche==1){
                    suivant.setClickable(false);
                }
                if(pastriche==0){
                    suivant.setClickable(true);
                }
                */


                int c = 1 + (int) (Math.random() * (20));
                int d = 1 + (int) (Math.random() * (20));
                TextView test = (TextView) findViewById(R.id.test);
                test.setText("                         "+c+" * "+d+" =");

                result = c*d; //Calcul du résultat attendu
                cpt=cpt+1;

                //Affichage du nbr de questions jouées
                //TextView cpta = (TextView) findViewById(R.id.cpta);
                //cpta.setText(""+cpt+" / 20");
                pastriche=1;
                ok.setClickable(true);



            }
        });


}
    public void CalculScore (int sucess){
        score=+sucess;
    }

    public void Verification(int result, int result2){
        if(result==result2){
            sucess++;

            TextView resultat = (TextView) findViewById(R.id.resultat);
            resultat.setText("Bien joué !!!");
            triche =1;
            pastriche=0;



        }else
        {
            TextView resultat = (TextView) findViewById(R.id.resultat);
            resultat.setText("Dommage !");
            triche =0;
            pastriche=1;

        }
    }

    public void ScoreMax(int scoreencours){
        if(scoreencours>=scoremax){
            scoremax=scoreencours;

            System.out.println("[debug] on enregistre le novueau score max du tel"+ scoremax);

            SharedPreferences meilleurScore = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = meilleurScore.edit();
            editor.putInt("meilleurScore5", scoremax);
            editor.commit();
        }
    }
}

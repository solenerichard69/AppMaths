package com.example.premiertest;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.CountDownTimer;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;



public class Add1 extends AppCompatActivity {
    public int counter = 30; // temps de countdown en secondes
    Integer sucess=0;
    Integer score=0;
    Integer result;
    Integer result1;
    Integer cpt=1;
    Integer triche=0;
    TextView chrono; // déclaration du textview chrono présent dans layout
    private Button backbta1;

   // la méthode onCreate() est appelée à la création de l'activité
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // on associe l'acticité au layout du meme nom
        setContentView(R.layout.activity_add1);
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
                chrono.setText(counter+""); // on met a jour l'affichage sur l'activité
            }

            // on redéfinit la méthode onFinish : que fait-t'on à la fin du compte à rebours?
            public void onFinish(){
                int ValScore = score;
                Intent otherAct =new Intent(getApplicationContext(), afficheScore.class);
                otherAct.putExtra("Valeur", ValScore);
                startActivity(otherAct);
                finish();
            }
        };

        // on lance le compte a rebours :

        monCompteARebours.start();

        // *********************************//
        // reste du code
        // *********************************//

        //Mise en place de l'affichage du calcul
        Integer a = 0;
        Integer b = 0;


        a = 1 + (int) (Math.random() * (100));
        b = 1 + (int) (Math.random() * (100));


        TextView test = (TextView) findViewById(R.id.test);
        test.setText(""+a+" + "+b+" =  ?");
        result = a+b; //Calcul du résultat attendu

        TextView cpta = (TextView) findViewById(R.id.cpta);
        cpta.setText(""+cpt+" / 10");


        //Récupére la valeur d'édit text et la vérifie
        Button ok = findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText remplir = (EditText)findViewById(R.id.remplir);
                int nb = (int) Integer.parseInt(remplir.getText().toString());


                /* Pour éviter que lorsqu'on appuie sur OK sans edit text ca crash
                                if(remplir.getText()==null){
                    TextView resultat = (TextView) findViewById(R.id.resultat);
                    resultat.setText("ERREUR");
                }else
                 */

                Verification(result,nb);
                CalculScore(sucess);

                TextView affichagescore = (TextView) findViewById(R.id.affichagescore);
                affichagescore.setText("Score : "+score);
                remplir.getText().clear();


            }
        });


        //Fonction pour ne pas tricher
        /*
                if(triche ==1){
            ok.setEnabled(false);
        }else
            if(triche==0){
                ok.setEnabled(true);
            }
         */



        Button suivant = findViewById(R.id.suivant);
        suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                triche=0;
                int c = 1 + (int) (Math.random() * (100));
                int d = 1 + (int) (Math.random() * (100));
                TextView test = (TextView) findViewById(R.id.test);
                test.setText(""+c+" + "+d+" =  ?");

                result = c+d; //Calcul du résultat attendu
                cpt=cpt+1;

                //Affichage du nbr de questions jouées
                TextView cpta = (TextView) findViewById(R.id.cpta);
                cpta.setText(""+cpt+" / 10");
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

        }else
        {
            TextView resultat = (TextView) findViewById(R.id.resultat);
            resultat.setText("Dommage !");
            triche =0;

        }

    }

}


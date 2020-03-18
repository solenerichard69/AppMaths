package com.example.premiertest;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;



public class Add1 extends AppCompatActivity {
    public static Chronometer chrono;
    Integer sucess=0;
    Integer score=0;
    private Button backbta1;
    boolean go=true;
    Integer result;
    Integer result1;
    Integer cpt=1;
    Integer triche=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add1);
        this.backbta1= (Button)findViewById(R.id.backbt);

        backbta1.setOnClickListener(new View.OnClickListener() {
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





     /* Intent otherAct1 = getIntent();
        if (otherAct1!= null){
            Boolean goChrono=false;
            if (otherAct1.hasExtra("GoChro")){
                goChrono=otherAct1.getBooleanExtra("GoChro", true);
                if(goChrono=true) {
                    chrono.start();
                }
            }
        } */

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



   /* public void Chrono (){

        if(go=true){
            chrono.start();
        }

    }*/
    }


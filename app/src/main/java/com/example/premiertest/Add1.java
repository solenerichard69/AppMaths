package com.example.premiertest;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.os.CountDownTimer;
import android.widget.EditText;
import android.widget.TextView;


public class Add1 extends AppCompatActivity {
    public int counter = 30; // temps de countdown en secondes
    Integer sucess=0;   //Variable qui s'incrémene lorsque le résultat est le bon
    Integer score=0;    //score en cours de l'utlisateur
    Integer result;     //résultat attendu
    Integer result1;    //résultat rentré par l'utilisateur
    Integer triche=0;   //pour éviter la triche et vérifier le parcours de l'utilisateur
    TextView chrono; // déclaration du textview chrono présent dans layout
    private Button backbta1;    //Bouton de retour
    Button ok;  //Bouton pour valider le calcul
    Integer pastriche=1;    //pour éviter la triche et vérifier le parcours de l'utilisateur une seconde fois
    Integer scoremax=0;     //Score maximal atteint dans le niveau
    CountDownTimer monCompteARebours;   //Compte à rebours pour le chronomètre


   //La méthode onCreate() est appelée à la création de l'activité
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //On associe l'acticité au layout du meme nom
        setContentView(R.layout.activity_add1);


        //MISE EN MEMOIRE DU SCORE MAXIMAL\\

        SharedPreferences mesprefsEnregistrees = PreferenceManager.getDefaultSharedPreferences(this);
        scoremax = mesprefsEnregistrees.getInt("meilleurScore", 0);//Mise en mémoire du score max sous le nom MeilleurScore
        //Lors de la fermeture de l'application, le score maximal de cette activité est mis en mémoire
        //Un score propre à chaque activité est conservé en mémoire


        //BOUTON RETOUR\\

        // on lie le bouton backbt avec l'attribut de classe backbta1
        this.backbta1= (Button)findViewById(R.id.backbt);
        backbta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // action effectuée quand on clique sur "back"
                // on ferme simplement l'activité. Si l'activité appelante  (ici Niveau.class) n'était
                // pas fermée, on reviendra automatiquement dessus. Elle était en arriere-plan.
                 monCompteARebours.cancel();
                finish();
            }
        });


        //MISE EN PLACE DU CHRONO\\\

        //Chrono le textview de l'activité sera utilisé pour afficher le chronometre
        //On lie chrono l'attribut, avec chrono le textview du layout.
        //On affichera la valeur du chronometre à l'interieur de chrono
        this.chrono= (TextView) findViewById(R.id.chrono);

        // on définit un nouveau compte à rebours : objet CountDownTimer
        // on lui passe en parametre le nombre de seconde (counter) et le délai entre chaque tic (1s)
         monCompteARebours =  new  CountDownTimer(counter*1000, 1000){
            // on redéfinit la méthode onTick
            public void onTick (long millisUntilFinish){
                counter--; // on diminue le temps restant
                chrono.setText("\n                 "+counter+""); // on met a jour l'affichage sur l'activité
            }

            // on redéfinit la méthode onFinish : que fait-t'on à la fin du compte à rebours?
            public void onFinish(){
                ScoreMax(score);    //Récupération du score maximal atteint dans l'activité grâce à la méthode ScoreMax
                int ValScore = score;   //Récupération du score sous la variable ValScore
                int ValScoremax =scoremax;  //Récupération du scoremax sous la variable ValScoreMax
                Intent otherAct =new Intent(getApplicationContext(), Affiche_score_N1.class);   //On s'apprête à ouvrir une activité otherAct, qui correspond à Affiche_score_N1.class
                otherAct.putExtra("Valeur", ValScore);  //On envoie ValScore sous le nom Valeur dans l'activté
                otherAct.putExtra("ValeurScoremax", ValScoremax);   //On envoie ValScoreMax sous le nom ValeurScoremax dans l'activité
                startActivity(otherAct);    //Début de l'activité otherAct
                finish();   //Fin
            }
        };

        //Début du compte a rebours :
        monCompteARebours.start();


        //MISE EN PLACE DU CALCUL\\

        //Initialisation
        Integer a = 0;
        Integer b = 0;

        //Génération de deux nombres aléatoires
        a = 1 + (int) (Math.random() * (15));
        b = 1 + (int) (Math.random() * (15));

        //Affichage du calcul
        TextView test = (TextView) findViewById(R.id.test);
        test.setText(+a+" + "+b+" =");
        result = a+b; //Calcul du résultat attendu


        //BOUTON OK\\

        ok = findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText remplir = (EditText)findViewById(R.id.remplir);    //Récupére la valeur saisie par l'utlisateur

                int nb = 0; //Déclaration et initialisation de nb

                //Test Exception pour empêcher le programme de bugguer si la saisie de l'utilisateur comporte des erreurs
                try {
                    //On récupére la valeur saisie par l'utilisateur
                    nb = (int) Integer.parseInt(remplir.getText().toString());
                }
                catch (Exception e) {

                }

                //Vérification que la valeur saisie correspond au resultat
                boolean resultoperation = Verification(result,nb);
                //Calcul du score
                CalculScore(sucess);

                //Passage au calcul suivant, seulement si le calcul en cours en juste
                if (resultoperation == true) {

                    //Generation d'une nouvelle ligne de calcul
                    int c = 1 + (int) (Math.random() * (15));
                    int d = 1 + (int) (Math.random() * (15));
                    TextView test = (TextView) findViewById(R.id.test); //Affichage su nouveau calcul
                    test.setText(+c+" + "+d+" =");

                    result = c+d; //Calcul du résultat attendu
                }

                //Affichage du score
                TextView affichagescore = (TextView) findViewById(R.id.affichagescore);
                affichagescore.setText("Score : "+score);
                //On nettoie le édittext remplir
                remplir.getText().clear();

            }
        });
    }

    //CALCUL DU SCORE AU FUR ET A MESURE\\
    public void CalculScore (int sucess){
        //Le score est incrémenté
        score=+sucess;
    }

    //VERIFICATION DU RESULTAT\\
    public boolean Verification(int result, int result2){
        //Si le resultat correspond au resultat trouvé
        if(result==result2){
            sucess++;   //Incrémentation du score par le biais de success
            triche =1;  //Variable pour la triche
            pastriche=0;    //Variable pour la triche


        }else
        {
            triche =0;  //Variable pour la triche
            pastriche=1;    //Variable pour la triche

        }
        return (result==result2);   //Retourner vrai si le résultat en bon
    }


    //CALCUL DU SCORE MAX\\
    public void ScoreMax(int scoreencours){
        //On regarde si le score en cours est plus grand ou pas que le score max enregistré
        if(scoreencours>=scoremax){
            scoremax=scoreencours;

            //Enregistrement en mémoire du meilleur score
            SharedPreferences meilleurScore = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = meilleurScore.edit();
            editor.putInt("meilleurScore", scoremax);
            editor.commit();


        }
    }


}


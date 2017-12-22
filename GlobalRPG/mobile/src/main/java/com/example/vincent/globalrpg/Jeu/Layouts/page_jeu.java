package com.example.vincent.globalrpg.Jeu.Layouts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.vincent.globalrpg.Jeu.MethodesMaths.methodMaths;
import com.example.vincent.globalrpg.Jeu.Monstre.Oisillon;
import com.example.vincent.globalrpg.Jeu.Personnage.Warrior;
import com.example.vincent.globalrpg.R;

/**
 * Created by Vincent on 17/11/2017.
 */

public class page_jeu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_jeu);

        final TextView texte2 = (TextView) findViewById(R.id.textView2);
        final TextView texte3 = (TextView) findViewById(R.id.textView3);
        final TextView texte6 = (TextView) findViewById(R.id.textView6);
        final TextView texte7 = (TextView) findViewById(R.id.textView7);

        final Button button1 = (Button) findViewById(R.id.button);
        final Button button2 = (Button) findViewById(R.id.button2);
        final Button button3 = (Button) findViewById(R.id.button3);
        final Button button4 = (Button) findViewById(R.id.button4);

        //button4.setVisibility (false);


        final Warrior personnage = new Warrior("Test");
        //Character test;
        //switch ()
        final Oisillon monstre = new Oisillon();

        methodMaths _methodMaths = new methodMaths();
        int checkRandom = _methodMaths.random(0, 10);

        texte2.setText(((Integer)personnage.personnage.initiale.getHp()).toString());
        texte3.setText(((Integer)monstre.monstre.initiale.getHp()).toString());
        texte6.setText(monstre.monstre.getNomMonstre() + "est vivant !");
        texte7.setText("Vous êtes vivant !");


        if(monstre.enVie())
            button4.setEnabled(false);
        else
        button4.setEnabled(true);

        if(checkRandom == 3)
        {
            button1.setEnabled(true);
            button2.setEnabled(true);
            button3.setEnabled(true);
        }
        else
        {
            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            monstre.attaquer(personnage.personnage);

            while (checkRandom != 3)
            {
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                if(personnage.enVie())
                    monstre.attaquer(personnage.personnage);
                else
                    break;
                texte2.setText(((Integer)personnage.personnage.initiale.getHp()).toString());
                checkRandom = _methodMaths.random(0,10);
            }

            button1.setEnabled(true);
            button2.setEnabled(true);
            button3.setEnabled(true);
            monstre.attaquer(personnage.personnage);

        }

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(monstre.enVie())
                {
                    personnage.attaquer(monstre.monstre);
                    texte3.setText(((Integer)monstre.monstre.initiale.getHp()).toString());
                    texte6.setText(monstre.monstre.getNomMonstre() + " est vivant!");
                }
                else
                    texte6.setText(monstre.monstre.getNomMonstre() + " est mort!");


                if(personnage.enVie()) {
                    monstre.attaquer(personnage.personnage);
                    texte2.setText(((Integer)personnage.personnage.initiale.getHp()).toString());
                    texte7.setText("Vous êtes encore en vie !");
                }

                if(!personnage.enVie() || !monstre.enVie())
                {
                    if(!personnage.enVie())
                        texte7.setText("Vous êtes mort ... !");
                    if(!monstre.enVie())
                        texte6.setText(monstre.monstre.getNomMonstre() + " est mort!");
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    button3.setEnabled(false);
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                personnage.defendre(personnage);
                texte3.setText(((Integer)monstre.monstre.initiale.getHp()).toString());

                if(personnage.enVie() && monstre.enVie())
                {
                    monstre.attaquer(personnage.personnage);
                    texte2.setText(((Integer)personnage.personnage.initiale.getHp()).toString());
                    texte7.setText("Vous êtes encore en vie !");
                }

                if(!personnage.enVie() || !monstre.enVie())
                {
                    if(!personnage.enVie())
                        texte7.setText("Vous êtes mort ... !");
                    if(!monstre.enVie())
                        texte6.setText("Le monstre est mort!");
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    button3.setEnabled(false);
                }
            }

        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                personnage.soin(personnage);
                texte3.setText(((Integer)monstre.monstre.initiale.getHp()).toString());

                monstre.attaquer(personnage.personnage);
                texte2.setText(((Integer)personnage.personnage.initiale.getHp()).toString());
                texte7.setText("Vous êtes encore en vie !");

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                recreate();
                personnage.soin(personnage);
                personnage.soin(personnage);
                personnage.soin(personnage);
                personnage.soin(personnage);
                personnage.soin(personnage);
                personnage.soin(personnage);
                texte3.setText(((Integer)monstre.monstre.initiale.getHp()).toString());

                monstre.attaquer(personnage.personnage);
                texte2.setText(((Integer)personnage.personnage.initiale.getHp()).toString());
                texte7.setText("Vous avez recommencé le combat !");

            }
        });


        /*for(int i=0; i<9; i++)
        {
            personnage.attaquer(monstre.monstre);
            texte2.setText(((Integer)monstre.monstre.initiale.getHp()).toString());
            monstre.attaquer(personnage.personnage);
            texte.setText(((Integer)personnage.personnage.initiale.getHp()).toString());

        }*/


        //Cette boucle est fonctionnelle, on envoie les bons dégàs !
        /*while(monstre.initiale.getHpInit() >= 0)
        {
            texte.setText(((Integer)monstre.initiale.getHp()).toString());
            personnage.attaquer(monstre);
        }*/

        /*while(monstre.initiale.getHpInit() >= 0)
        {
            texte.setText(((Integer)monstre.initiale.getHp()).toString());
            personnage.attaquer(monstre);
           // texte2.setText(((Integer)personnage.personnage.initiale.getHp()).toString());
           // monstre.attaquer(personnage);

            try {
                wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/


    }
}
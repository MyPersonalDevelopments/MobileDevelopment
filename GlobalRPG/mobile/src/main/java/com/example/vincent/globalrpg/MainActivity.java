package com.example.vincent.globalrpg;

/**
 * Exemple de code :
 * http://forum.ironcraft.fr/topic/3354-les-bases-pour-crer-un-rpg/
 */

/**
 * Intent permet de changer de class
 */

import android.app.FragmentTransaction;
import android.content.Intent;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.vincent.globalrpg.Jeu.Fragments.fragment1;
import com.example.vincent.globalrpg.Jeu.Fragments.fragment2;
import com.example.vincent.globalrpg.Jeu.Monstre.Oisillon;
import com.example.vincent.globalrpg.Jeu.Personnage.Character;
import com.example.vincent.globalrpg.Jeu.Personnage.Warrior;
import com.example.vincent.globalrpg.Jeu.MethodesMaths.methodMaths;


public class MainActivity extends AppCompatActivity {/*implements fragment1.TextClicked {

    @Override
    public void sendText(String text){
        fragment1 frag = (fragment1)
                getSupportFragmentManager().findFragmentById(R.id.fragment);
        frag.updateText(text);
    }*/

    /*public void showAnotherFragment(){
        //Récupérer le FragmentManager
        FragmentManager fm = getFragmentManager();

        //Débuter la transaction des fragments
        FragmentTransaction ft = fm.beginTransaction();

        //Vérifier si les fragments existent
        fragment1 f1 = (fragment1) fm.findFragmentByTag("fragment1_tag");
        fragment2 f2 = (fragment2) fm.findFragmentByTag("fragment2_tag");

        //Sinon, les créer
        if(f1 == null){
            f1 = new fragment1();
            ft.replace(R.id.firstLayout, f1, "fragment1_tag");
        }else{
            ft.show(f1);
        }
        if(f2 == null){
            f2 = new fragment2();
            ft.replace(R.id.secondLayout, f2, "fragment2_tag");
        }else{
            ft.show(f2);
        }

        ft.addToBackStack(null);

        ft.commit();

    }*/

    @Override
    protected void onRestart(){
        super.onRestart();
        //Log.d("restartedup","Je suis bien passé!");
            Intent i = new Intent(MainActivity.this, MainActivity.class);  //your class
            startActivity(i);
            finish();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getFragmentManager();

        //Débuter la transaction des fragments
        FragmentTransaction ft = fm.beginTransaction();

        //Vérifier si les fragments existent
        fragment1 f1 = (fragment1) fm.findFragmentByTag("fragment1_tag");

        if(f1 == null){
            f1 = new fragment1();
            ft.replace(R.id.firstLayout, f1, "fragment1_tag");
        }else{
            ft.show(f1);
        }


        //fragment1 f1 = (fragment1) getSupportFragmentManager().findFragmentById(R.id.fragment);
        //fragment1 f1 = new fragment1();

        //f1.getFragmentManager().

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
            texte6.setText("Monstre vivant !");
            texte7.setText("Vous êtes vivant !");


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

//                    showAnotherFragment();

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
                            texte6.setText(monstre.monstre.getNomMonstre() + " est mort!");
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

                    onRestart();

                }
            });




    }



}

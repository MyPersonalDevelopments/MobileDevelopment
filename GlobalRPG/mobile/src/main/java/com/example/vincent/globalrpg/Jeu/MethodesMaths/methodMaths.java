package com.example.vincent.globalrpg.Jeu.MethodesMaths;

import java.util.Random;

/**
 * Created by Vincent on 15/11/2017.
 */

public class methodMaths {

    //Methode random pour avoir un chiffre compris entre min et max
    public int random(int min, int max) {
        Random rand = new Random();
        int nombreAleatoire = rand.nextInt(max - min + 1) + min;
        return nombreAleatoire;

    }
}

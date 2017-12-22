package com.example.vincent.globalrpg.Jeu.Monstre;

import com.example.vincent.globalrpg.Jeu.MethodesMaths.methodMaths;
import com.example.vincent.globalrpg.Jeu.Personnage.Character;

/**
 * Created by Vincent on 13/11/2017.
 */

public class Oisillon {
    public Monster monstre;
    public methodMaths _methodMaths;
    public int hpMax = 50;
    public int ad = 35;
    public int armure = 5;
    private int chanceCoupCritique = 20;
    private int chanceEsquive = 15;

    public Oisillon() {
        this.monstre = new Monster("Oisillon", hpMax, ad, armure, chanceCoupCritique, chanceEsquive);

        //Je SET (j'envoie) une valeur entière
        //monstre.initiale.setDegAdInit(25);
        //monstre.initiale.setHpInit(250);
        //monstre.initiale.setArmureInitS(10);

    }

    public void attaquer(Character _personnage) {
        int hpRestant = _personnage.initiale.getHp();
        monstre.initiale.setArmureInit(armure);

        if(this.monstre.initiale.getDegPhysicInit() - _personnage.initiale.getArmureInit() > 0){
            if(!esquive(_personnage.initiale.getChanceEsq())){
                if(coupCritique())
                    hpRestant = hpRestant - ((this.monstre.initiale.getDegPhysicInit()*2) - _personnage.initiale.getArmureInit());
                else
                    hpRestant = hpRestant - (this.monstre.initiale.getDegPhysicInit() - _personnage.initiale.getArmureInit());
            }

        }

        _personnage.initiale.setHp(hpRestant);

    }

    public void defendre() {
        monstre.initiale.setArmureInit(armure);

        int defense = 2 * monstre.initiale.getArmureInit();
        monstre.initiale.setArmureInit(defense);

    }

    public boolean enVie() {

        if(monstre.initiale.getHp() > 0)
            return true;
        else
            return false;

    }

    public boolean coupCritique() {
        int rdm = _methodMaths.random(0,100);
        if(rdm > (1 - chanceCoupCritique))
            return true;
        else
            return false;
    }

    public  boolean esquive(int e){
        int rdm = _methodMaths.random(0,100);
        if(rdm < e)
            return true;
        else
            return false;
    }

}

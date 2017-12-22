package com.example.vincent.globalrpg.Jeu.Personnage;

import com.example.vincent.globalrpg.Jeu.MethodesMaths.methodMaths;
import com.example.vincent.globalrpg.Jeu.Monstre.Monster;

import java.util.Locale;

/**
 * Created by Vincent on 13/11/2017.
 */

public class Warrior {
    public methodMaths _methodMaths;
    public Character personnage;
    private int hpMax = 300;
    private int ad = 8;
    private int armure = 25;
    private int chanceCoupCritique = 35;
    public int chanceEsquive = 20;

    public Warrior(String _nomPerso){
        this.personnage = new Character(_nomPerso, hpMax, ad, armure, chanceCoupCritique, chanceEsquive);
        //Je SET (j'envoie) une valeur entière
        //personnage.initiale.setDegAdInit(10);
        //personnage.initiale.setHp(300);
        //hpMax = personnage.initiale.getHp();
        //personnage.initiale.setArmureInit(20);

    }

    public void attaquer(Monster _monstre) {
        int hpRestant = _monstre.initiale.getHp();
        personnage.initiale.setArmureInit(armure);

        if(this.personnage.initiale.getDegPhysicInit() - _monstre.initiale.getArmureInit() > 0)
        {
            if(!esquive(_monstre .initiale.getChanceEsq()))
            if(coupCritique())
                hpRestant = hpRestant - ((this.personnage.initiale.getDegPhysicInit()*2) - _monstre.initiale.getArmureInit());
            else
                hpRestant = hpRestant - (this.personnage.initiale.getDegPhysicInit() - _monstre.initiale.getArmureInit());
        }

        _monstre.initiale.setHp(hpRestant);

    }

    public void defendre(Warrior _warrior) {
        personnage.initiale.setArmureInit(armure);

        int defense = 2*_warrior.personnage.initiale.getArmureInit();
        _warrior.personnage.initiale.setArmureInit(defense);

    }

    public void soin(Warrior _warrior) {
        int soin = _warrior.personnage.initiale.getHp() + 40;
        if(soin >= hpMax)
            soin = hpMax;
        _warrior.personnage.initiale.setHp(soin);

    }

    public boolean enVie() {
        if(personnage.initiale.getHp() > 0)
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

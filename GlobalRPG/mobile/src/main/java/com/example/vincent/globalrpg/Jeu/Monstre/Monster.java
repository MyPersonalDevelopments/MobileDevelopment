package com.example.vincent.globalrpg.Jeu.Monstre;

import com.example.vincent.globalrpg.Jeu.Personnage.Warrior;
import com.example.vincent.globalrpg.Jeu.Stats;

/**
 * Created by Vincent on 13/11/2017.
 */

public class Monster {
    public Stats initiale;
    protected String nomMonstre;

    public Monster(String _nomMonstre){
        //this.initiale = _initiale;
        initiale = new Stats();
        this.nomMonstre = _nomMonstre;

    }

    //Constructeur d'un Monstre
    public Monster(String _nomMonstre, int _hpMax, int _ad, int _defense, int _chanceCritique, int _chanceEsq) {
        //this.initiale = _initiale;
        initiale = new Stats(_hpMax, _ad, _defense, _chanceCritique, _chanceEsq);
        this.nomMonstre = _nomMonstre;

    }

    public String getNomMonstre() {
        return nomMonstre;

    }
}

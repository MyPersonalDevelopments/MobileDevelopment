package com.example.vincent.globalrpg.Jeu.Personnage;

import com.example.vincent.globalrpg.Jeu.Stats;

/**
 * Created by Vincent on 13/11/2017.
 */

public class Character {
   public Stats initiale;
   protected String nomPerso;

   public Character(String _nomPerso) {
      //this.initiale = _initiale;
      initiale = new Stats();
      this.nomPerso = _nomPerso;

   }

   //Constructeur d'un Guerrier
   public Character(String _nomPerso, int _hpMax, int _ad, int _defense, int _chanceCoupCritique, int _chanceEsquive) {
      //this.initiale = _initiale;
      initiale = new Stats(_hpMax, _ad, _defense, _chanceCoupCritique, _chanceEsquive);
      this.nomPerso = _nomPerso;

   }


}

package com.example.vincent.globalrpg.Jeu;

/**
 * Created by Vincent on 13/11/2017.
 * <p>
 * public : Accessible partout
 * private : seulement en héritage (ou classe)
 * protected : tout le package
 */

/**
 * public : Accessible partout
 * private : seulement en héritage (ou classe)
 * protected : tout le package
 */

/**
 * Ici, nous allons retrouver un constructeur de stats
 * HP / MP / DEF / Dégàs : AD ou AP? (MP * X) /
 */

public class Stats {
    protected int hp;
    protected int mpInit;
    protected int ArmureInit;
    protected int degPhysicInit;
    protected int degMagicInit;
    protected int level;
    protected int chanceCoupCritique;
    protected int chanceEsq;

    public int getHp() {
        return hp;
    }

    public void setHp(int _hp) {
        this.hp = _hp;
        if(this.hp < 0)
            this.hp = 0;
    }

    public int getChanceCoupCritique() {
        return chanceCoupCritique;
    }

    public void setChanceCoupCritique(int _chanceCoupCritique) {
        this.chanceCoupCritique = _chanceCoupCritique;

    }

    public int getChanceEsq() {
        return chanceEsq;
    }

    public void setChanceEsq(int _chanceEsq) {
        this.chanceEsq = _chanceEsq;

    }

    public int getMpInit() {
        return mpInit;
    }

    public void setMpInit(int _mpInit) {
        this.mpInit = _mpInit;
    }

    public int getArmureInit() {
        return ArmureInit;
    }

    public void setArmureInit(int _ArmureInit) {
        this.ArmureInit = _ArmureInit;
    }

    public int getDegPhysicInit() {
        return degPhysicInit;
    }

    public void setDegPhysicInit(int _degPhysicInit) {
        this.degPhysicInit = _degPhysicInit;
    }

    public int getDegMagicInit() {
        return degMagicInit;
    }

    public void setDegMagicInit(int _degMagicInit) {
        this.degMagicInit = _degMagicInit;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int _level) {
        this.level = _level;
    }

    //Constructeur par défaut
    public Stats() {
        this.level = 1;
        this.hp = 200;
        this.ArmureInit = 10;
        this.mpInit = 0;
        this.degPhysicInit = 0;
        this.degMagicInit = 0;
        this.chanceCoupCritique = 20;
        this.chanceEsq = 10;


    }

    //Constructeur du Guerrier/Monstre
    public Stats(int _hp, int _degPhysicInit, int _ArmureInit, int _chanceCoupCritique, int _chanceEsq) {
        this.hp = _hp;
        this.ArmureInit = _ArmureInit;
        this.degPhysicInit = _degPhysicInit;
        this.chanceCoupCritique = _chanceCoupCritique;
        this.chanceEsq = _chanceEsq;

    }


}

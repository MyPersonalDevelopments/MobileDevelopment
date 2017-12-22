package com.example.vincent.globalrpg.Jeu.Bdd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by asus on 06/12/2017.
 */

public class Database extends SQLiteOpenHelper {

    public static final String CHARACTER_TABLE_NAME = "Character";
    public static final String CHARACTER_KEY = "id";
    public static final String CHARACTER_NOM = "intitule";
    public static final String CHARACTER_NIVEAU = "niveau";
    public static final String CHARACTER_EXPERIENCE = "experience";
    public static final String CHARACTER_PV = "pv";
    public static final String CHARACTER_ATTAQUE = "attaque";
    public static final String CHARACTER_DEFENSE = "defense";

    public static final String LEVEL_TABLE_NAME = "Leveling";
    public static final String LEVEL_ID = "id";
    public static final String LEVEL_EXPERIENCE = "experienceDuNiveau";
    public static final String LEVEL_ATTAQUE = "attaqueGagner";
    public static final String LEVEL_DEFENSE = "defenseGagner";
    public static final String LEVEL_PV = "pvGagner";

    public static final String MONSTER_TABLE_NAME = "Monster";
    public static final String MONSTER_KEY = "id";
    public static final String MONSTER_NOM = "intitule";
    public static final String MONSTER_NIVEAU = "niveau";
    public static final String MONSTER_EXPERIENCE = "experience";
    public static final String MONSTER_PV = "pv";
    public static final String MONSTER_ATTAQUE = "attaque";
    public static final String MONSTER_DEFENSE = "defense";



   /* public static final String CHARACTER_TABLE_CREATE =
            "CREATE TABLE " + CHARACTER_TABLE_NAME + " (" +
                    CHARACTER_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    CHARACTER_NOM + " TEXT, " +
                    CHARACTER_NIVEAU + " REAL, " +
                    CHARACTER_EXPERIENCE + " REAL, " +
                    CHARACTER_PV + " REAL, " +
                    CHARACTER_ATTAQUE + " REAL, " +
                    CHARACTER_DEFENSE + "REAL,);";

    public static final String MONSTER_TABLE_CREATE =
            "CREATE TABLE " + MONSTER_TABLE_NAME + " (" +
                    MONSTER_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    MONSTER_NOM + " TEXT, " +
                    MONSTER_TYPE + " TEXT, "+
                    MONSTER_ATTAQUE + " REAL);";

*/
    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL(CHARACTER_TABLE_CREATE);
        //db.execSQL(MONSTER_TABLE_CREATE);
        //db.execSQL(LEVEL_TABLE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(CHARACTER_TABLE_DROP);
        onCreate(db);
    }

    public static final String CHARACTER_TABLE_DROP = "DROP TABLE IF EXISTS " + CHARACTER_TABLE_NAME + ";";

}

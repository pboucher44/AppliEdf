package com.presentationtp;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class CreateBdClients extends SQLiteOpenHelper {

    private static final String TABLE_CLIENTS = "TCLIENTS";
    static final String COL_ID = "_id";
    private static final String COL_NOM = "NOM";
    private static final String COL_PRENOM = "PRENOM";
    private static final String COL_ADRESSE = "ADRESSE";



    private static final String CREATE_BDD = "CREATE TABLE " + TABLE_CLIENTS + "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_NOM + " TEXT NOT NULL, " + COL_PRENOM + " TEXT NOT NULL, " + COL_ADRESSE + " TEXT NOT NULL);";
    //private static final String CREATE_BDD = "CREATE TABLE TCLIENTS(IDCLI STRING PRIMARY KEY, NOM TEXT NOT NULL, PRENOM TEXT NOT NULL, ADRESSE TEXT, EMAIL TEXT, TEL TEXT);";

    //constructeur
    public CreateBdClients(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BDD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_CLIENTS + ";");
        onCreate(db);
    }
}

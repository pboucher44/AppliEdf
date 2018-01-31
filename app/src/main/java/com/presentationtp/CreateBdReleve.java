package com.presentationtp;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class CreateBdReleve extends SQLiteOpenHelper{
    private static final String TABLE_RELEVE = "TRELEVE";
    static final String COL_ID = "_id";
    private static final String COL_DATERELEVE= "DateReleve";
    private static final String COL_CPTHC = "CptHC";
    private static final String COL_CPTHP = "CptHP";
    private static final String COL_CODECLI = "CodeCli";
    private static final String COL_TYPE = "TypeReleve";


    private static final String CREATE_BDD = "CREATE TABLE " + TABLE_RELEVE + "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_DATERELEVE + " TEXT NOT NULL, " + COL_CPTHC + " NUMERIC NOT NULL, " + COL_CPTHP + " NUMERIC NOT NULL, " + COL_CODECLI+ " NUMERIC NOT NULL, "+COL_TYPE+" TEXT NOT NULL);";

    //constructeur
    public CreateBdReleve(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BDD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_RELEVE + ";");
        onCreate(db);
    }
}

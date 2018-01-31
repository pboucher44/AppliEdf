package com.presentationtp;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;



public class ReleveDAO {

    static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "EDF.db";
    static final String TABLE_RELEVE = "TRELEVE";
    static final String COL_ID = "_id";
    static final int NUM_COL_ID = 0;
    static final String COL_DATERELEVE = "DateReleve";
    static final int NUM_COL_DATERELEVE = 1;
    static final String COL_CPTHC = "CptHC";
    static final int NUM_COL_CPTHC= 2;
    static final String COL_CPTHP = "CptHP";
    static final int NUM_COL_CPTHP = 3;
    static final String COL_CODECLI = "CodeCli";
    static final int NUM_COL_CODECLI = 4;
    static final String COL_TYPE= "TypeReleve";
    static final int NUM_COL_TYPE = 5;


    private CreateBdReleve bdReleve;
    private Context context;
    private SQLiteDatabase db;

    //constructeur
    public ReleveDAO(Context context) {
        this.context = context;
        bdReleve = new CreateBdReleve(context, NOM_BDD, null, VERSION_BDD);
    }

    //méthodes
    public ReleveDAO open() {
        db = bdReleve.getWritableDatabase();
        return this;
    }

    public ReleveDAO close() {
        db.close();
        return this;
    }

    public long insererReleve(Releve unReleve) {
        ContentValues values = new ContentValues();
        values.put(COL_DATERELEVE, unReleve.getDateReleve());
        values.put(COL_CPTHC, unReleve.getcptHC());
        values.put(COL_CPTHP, unReleve.getcptHP());
        values.put(COL_CODECLI, unReleve.getCodeCli());
        values.put(COL_TYPE, unReleve.getTypeReleve());
        return db.insert(TABLE_RELEVE, null, values);

    }

    public Cursor getData() {
        return db.rawQuery("SELECT * FROM " + TABLE_RELEVE + ";", null);
    }
}

package com.presentationtp;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Adapter;


public class BdAdapter {
    static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "EDF.db";
    static final String TABLE_CLIENTS = "TCLIENTS";
    static final String COL_ID = "_id";
    static final int NUM_COL_ID = 0;
    static final String COL_NOM = "NOM";
    static final int NUM_COL_NOM = 1;
    static final String COL_PRENOM = "PRENOM";
    static final int NUM_COL_PRENOM = 2;
    static final String COL_ADRESSE = "ADRESSE";
    static final int NUM_COL_ADRESSE = 3;


    private CreateBdClients bdClients;
    private Context context;
    private SQLiteDatabase db;

    //constructeur
    public BdAdapter(Context context) {
        this.context = context;
        bdClients = new CreateBdClients(context, NOM_BDD, null, VERSION_BDD);
    }

    //méthodes
    public BdAdapter open() {
        db = bdClients.getWritableDatabase();
        return this;
    }

    public BdAdapter close() {
        db.close();
        return this;
    }

    public long insererClient(Client unClient) {
        ContentValues values = new ContentValues();
        values.put(COL_NOM, unClient.getNomcli());
        values.put(COL_PRENOM, unClient.getPrenomcli());
        values.put(COL_ADRESSE, unClient.getAdressecli());
        return db.insert(TABLE_CLIENTS, null, values);

    }

    public Cursor getData() {
        return db.rawQuery("SELECT * FROM " + TABLE_CLIENTS + ";", null);
    }
}

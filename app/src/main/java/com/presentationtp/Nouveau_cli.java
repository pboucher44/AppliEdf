package com.presentationtp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.app.Activity;
import android.widget.EditText;
import android.widget.Toast;

public class Nouveau_cli extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nouveauclient);


        Button buttonEnregistrerNouveauCli = (Button) findViewById(R.id.buttonEnregistrerCli);
        buttonEnregistrerNouveauCli.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                enregistrerClient();

            }
        });

        Button buttonQuitterMenuCli = (Button) findViewById(R.id.buttonQuitterMenuCli);
        buttonQuitterMenuCli.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                finish();
            }

        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nouv_client:
                Toast.makeText(getApplicationContext(), "Vous y êtes déja", Toast.LENGTH_LONG).show();
                return true;

            case R.id.client:
                Toast.makeText(getApplicationContext(), "ouverture de la fenêtre client existant ", Toast.LENGTH_LONG).show();
                Intent intent2 = new Intent(Nouveau_cli.this, Liste_cli.class);
                startActivityForResult(intent2,0);
                return true;

            case R.id.menuQuitter:
                finish();

        }
        return false;
    }

    public void enregistrerClient() {

        //insertion du nouveau client dans la base de données
        BdAdapter clientBdd = new BdAdapter(this);
        clientBdd.open();
        //on récupère les valeurs saisies dans l'interface
        EditText nomsaisi = (EditText) findViewById(R.id.editTextNomCli);
        String nom = nomsaisi.getText().toString();
        EditText prenomsaisi = (EditText) findViewById(R.id.editTextPrenomCli);
        String prenom = prenomsaisi.getText().toString();
        EditText adressesaisi = (EditText) findViewById(R.id.editTextAdresse);
        String adresse = adressesaisi.getText().toString();

        //on stocke les données dans la table client
        Client nouveauClient = new Client(nom, prenom, adresse);
        clientBdd.insererClient(nouveauClient);
        Toast.makeText(getApplicationContext(), " nouveau client enregistré ", Toast.LENGTH_LONG).show();
    }


}



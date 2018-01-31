package com.presentationtp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.Menu;

import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.view.MenuItem;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {

    public String type;
    final String EXTRA_ID="id_cli";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //procédure pour créer la base de données et remplir la table client avec qq clients
        //remplirBD();





        Button btn = (Button) findViewById(R.id.buttonEnvoyer); //pour créer l'évènement sur le boutonEnvoyer
        btn.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {
                int CptHC1 = 1224;
                int CptHP1 = 568;
                EditText cpthc2saisi = (EditText) findViewById(R.id.editTextHC);
                EditText cpthp2saisi = (EditText) findViewById(R.id.editTextHP);
                int CptHC2 = Integer.parseInt(cpthc2saisi.getText().toString());
                int CptHP2 = Integer.parseInt(cpthp2saisi.getText().toString());
                Toast.makeText(getApplicationContext(), "consommation HC : " + Consommation(CptHC1, CptHC2), Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), "consommation HP : " + Consommation(CptHP1, CptHP2), Toast.LENGTH_LONG).show();
                enregistrerReleve();

            }

        });

    }


    public void enregistrerReleve() {

        //insertion d'un nouveau releve dans la base de données
        ReleveDAO releveBdd = new ReleveDAO(this);
        releveBdd.open();
        //on récupère les valeurs saisies dans l'interface
        EditText datereleveSaisi = (EditText) findViewById(R.id.editTextDateReleve);
        String dateReleve = datereleveSaisi.getText().toString();

        EditText cptHCsaisi = (EditText) findViewById(R.id.editTextHC);
        String HC = cptHCsaisi.getText().toString();
        Integer cptHC = Integer.parseInt(HC);

        EditText cptHPsaisi = (EditText) findViewById(R.id.editTextHP);
        String HP = cptHPsaisi.getText().toString();
        Integer cptHP = Integer.parseInt(HP);

        EditText codeclisaisi = (EditText) findViewById(R.id.editTextCodeCli);
        String ccli = codeclisaisi.getText().toString();
        Integer codecli = Integer.parseInt(ccli);

        // On place un écouteur sur le groupe de boutons radios pour voir lequel est coché
        ((RadioGroup) findViewById(R.id.RadioGroup1)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton typesaisi = (RadioButton) findViewById(checkedId);
                String type = typesaisi.getText().toString();
            }

        });

        //on stocke les données dans la table releve
        Releve nouveauReleve = new Releve(dateReleve, cptHC, cptHP, codecli, type);
        releveBdd.insererReleve(nouveauReleve);
        Toast.makeText(getApplicationContext(), " nouveau releve enregistré ", Toast.LENGTH_LONG).show();
    }


    public void remplirBD() {
        BdAdapter clientBdd = new BdAdapter(this);
        //creation d'un client

        Client client1 = new Client("Contant", "Nelly", "Nantes");
        Client client2 = new Client("Ghaddar", "Samy", "Nantes");
        //on ouvre la base de données
        clientBdd.open();
        //on insère client1 puis client2
        clientBdd.insererClient(client1);
        clientBdd.insererClient(client2);
        //le curseur pour afficher le nombre de clients dans la base
        Cursor c = clientBdd.getData();
        Toast.makeText(getApplicationContext(), " il y a " + String.valueOf(c.getCount()) + " clients ", Toast.LENGTH_LONG).show();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public int Consommation(int cptAncien, int cptNouv) {
        int consomme = cptNouv - cptAncien;
        return consomme;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nouv_client:
                Toast.makeText(getApplicationContext(), "ouverture de la fenêtre nouveau client ", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, Nouveau_cli.class);
                startActivity(intent);
                return true;

            case R.id.client:
                Toast.makeText(getApplicationContext(), "ouverture de la fenêtre client existant ", Toast.LENGTH_LONG).show();
                Intent intent2 = new Intent(MainActivity.this, Liste_cli.class);
                startActivityForResult(intent2,0);
                return true;

            case R.id.menuQuitter:
                finish();

        }
        return false;
    }



    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode==RESULT_OK){
            String s=data.getStringExtra(EXTRA_ID);
            final EditText idlu=(EditText) findViewById(R.id.editTextCodeCli);
            idlu.setText(s);
        }
    }

}


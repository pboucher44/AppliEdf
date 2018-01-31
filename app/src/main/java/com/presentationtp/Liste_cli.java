package com.presentationtp;

/**
 * Created by Pierre Boucher on 30/01/2018.
 */

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;


public class Liste_cli extends AppCompatActivity {

    final String EXTRA_ID="id_cli";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listeclients);



        BdAdapter clientBdd = new BdAdapter(this);
        clientBdd.open();
        Cursor c = clientBdd.getData();
        String[] colonnes = new String[]{BdAdapter.COL_NOM, BdAdapter.COL_PRENOM, BdAdapter.COL_ADRESSE};
        int[] to = new int[]{R.id.textViewNom, R.id.textViewPrenom, R.id.textViewAdresse};

        SimpleCursorAdapter dataAdapter = new SimpleCursorAdapter(this, R.layout.style_liste, c, colonnes, to, 0);

        /*List<String> clients = new ArrayList<String>();

        clients.add("1 Contant Nelly");

        clients.add("2 Ghaddar Sami");

        clients.add("3 Bourgeois Nicolas");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, clients);*/
        ListView liste = (ListView) findViewById(R.id.listViewCli);
        TextView titre =new TextView(this);
        titre.setText("liste des clients");
        //permet d'afficher une entête à la liste des clients
        liste.addHeaderView(titre);
        liste.setAdapter(dataAdapter);
        clientBdd.close();

        // Gestion des clics sur les lignes
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View container, int position, long id) {
                // faites ici ce que vous voulez
                Toast.makeText(getApplicationContext(), " vous avez selectionné le "+id+" client ", Toast.LENGTH_LONG).show();
                Intent i1=new Intent();
                //pour transformer le long en string
                String numcli=id+"";
                i1.putExtra(EXTRA_ID,numcli);
                setResult(RESULT_OK,i1);
                finish();
            }};
// Utilisation avec notre listview
        liste.setOnItemClickListener(itemClickListener);

        Button btnQuitterCli = (Button) findViewById(R.id.btnQuitterCli);
        btnQuitterCli.setOnClickListener(new View.OnClickListener()

        {
            public void onClick (View v){

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
                Toast.makeText(getApplicationContext(), "ouverture de la fenêtre client existant ", Toast.LENGTH_LONG).show();
                Intent intent2 = new Intent(Liste_cli.this, Nouveau_cli.class);
                startActivityForResult(intent2,0);
                return true;

            case R.id.client:
                Toast.makeText(getApplicationContext(), "Vous y êtes déja", Toast.LENGTH_LONG).show();
                return true;

            case R.id.menuQuitter:
                finish();

        }
        return false;
    }

}







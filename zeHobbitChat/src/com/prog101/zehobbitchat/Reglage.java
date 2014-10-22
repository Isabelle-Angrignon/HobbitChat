package com.prog101.zehobbitchat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.crypto.spec.PSource;

public class Reglage extends Activity {
    private int mRegionSelectionne;
    private int mPortUDP=6000;
    private String mPseudo = "Ariekor";
    Spinner spinner;
    EditText port;
    EditText Pseudo;
    public final static String EXTRA_REGION =
            "com.prog101.zehobbitchat.REGION";
    public final static String EXTRA_PORT =
            "com.prog101.zehobbitchat.PORT";
    public final static String EXTRA_PSEUDO =
            "com.prog101.zehobbitchat.PSEUDO";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reglage);
             
        // création d'un spinner avec choix définis dans un fichier XML
        spinner = (Spinner)findViewById(R.id.spinner_region);
        port = (EditText)findViewById(R.id.PortUdp);
        Pseudo = (EditText)findViewById(R.id.ZePseudo);
        // assignation d'un gestionnaire d'événements
        spinner.setOnItemSelectedListener(new InfosSpinner());
                
    }
    private boolean estValide()
    {
        boolean temp = true;
        if(Pseudo.getText().toString().length() != 0){
            temp = false;
            Toast.makeText(getApplicationContext(), "Vous devez avoir un pseudo", Toast.LENGTH_SHORT).show();
        }
        if(port.getText().toString().length() != 0){
            temp = false;
            Toast.makeText(getApplicationContext(), "Vous devez avoir entré un port entre 1024 et 65 535", Toast.LENGTH_SHORT).show();
        }
                
        return true;
    }
    public void connection(View V)
    {
        String Message ="";
        if ( estValide())
        {
        Intent intent = new Intent(this, HobbitChat.class);
        mPseudo = Pseudo.getText().toString();       
        mPortUDP = Integer.parseInt(port.getText().toString());
        intent.putExtra(EXTRA_REGION, mRegionSelectionne);
        intent.putExtra(EXTRA_PORT, mPortUDP);
        intent.putExtra(EXTRA_PSEUDO, mPseudo);
        startActivity(intent);
        }
    }
    
    private class InfosSpinner implements OnItemSelectedListener {
        private boolean premiereFois = true;
        
        @Override
        public void onItemSelected(AdapterView<?> spinner, View vue, 
                                   int index, long id) {
            
            // le premier appel à la méthode est provoqué par
            // l'affichage du spinner et non par l'intervention de
            // l'utilisateur
            if (premiereFois) {
                premiereFois = false;
            } else {
                mRegionSelectionne = spinner.getSelectedItemPosition();
              
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> spinner) {
            // appelé seulement si un item est retiré pas programmation
        }
    }
    
}

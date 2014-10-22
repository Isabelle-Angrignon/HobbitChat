package com.prog101.zehobbitchat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class HobbitChat extends Activity {
    TextView textTemp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobbit_chat);
        textTemp = (TextView)findViewById(R.id.potato);
        Intent intent = getIntent();
        String temp = intent.getStringExtra(Reglage.EXTRA_PSEUDO);
        textTemp.setText(temp);
    }
}

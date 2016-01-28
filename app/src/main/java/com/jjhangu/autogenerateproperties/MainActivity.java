package com.jjhangu.autogenerateproperties;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.jjhangu.autogenerateproperties.agconstant.AgConstant;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ((EditText)findViewById(R.id.ettext)).append("## this is from properties \n");
        ((EditText)findViewById(R.id.ettext)).append("secure.ip: " + PropertiesManager.getInstanceOf(getApplication()).getKey("secure.ip") + "\n");
        ((EditText)findViewById(R.id.ettext)).append("secure.port: " + PropertiesManager.getInstanceOf(getApplication()).getKey("secure.port") + "\n");
        ((EditText)findViewById(R.id.ettext)).append("config.name: " + PropertiesManager.getInstanceOf(getApplication()).getKey("config.name") + "\n");
        ((EditText)findViewById(R.id.ettext)).append("config.id: " + PropertiesManager.getInstanceOf(getApplication()).getKey("config.id") + "\n");

        ((EditText)findViewById(R.id.ettext)).append("\n\n\n");
        ((EditText)findViewById(R.id.ettext)).append("## this is from Constants \n");
        ((EditText)findViewById(R.id.ettext)).append("secure.ip: " + AgConstant.SECURE_IP+ "\n");
        ((EditText)findViewById(R.id.ettext)).append("secure.port: " + AgConstant.SECURE_PORT + "\n");
        ((EditText)findViewById(R.id.ettext)).append("config.name: " + AgConstant.CONFIG_NAME + "\n");
        ((EditText)findViewById(R.id.ettext)).append("config.id: " + AgConstant.CONFIG_ID + "\n");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

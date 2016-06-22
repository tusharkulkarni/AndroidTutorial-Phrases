package com.tushar.gridlayout_demo;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

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

    public void listenPhrase(View view){
        Button btn = (Button) view;

        int phraseSelected = Integer.parseInt(btn.getTag().toString());
        int resourceId = 0;
       /* switch(phraseSelected){
            case 1 :
                resourceId = R.raw.doyouspeakenglish;

                break;
            case 2 :
                resourceId = R.raw.goodevening;
                break;
            case 3 :
                resourceId = R.raw.hello;
                break;
            case 4 :
                resourceId = R.raw.howareyou;
                break;
            case 5 :
                resourceId = R.raw.ilivein;
                break;
            case 6 :
                resourceId = R.raw.mynameis;
                break;
            case 7 :
                resourceId = R.raw.please;
                break;
            case 8 :
                resourceId = R.raw.welcome;
                break;
        }*/

        String idStr = getResources().getResourceEntryName(view.getId());


        resourceId = getResources().getIdentifier(idStr, "raw", "com.tushar.gridlayout_demo");

        Log.i("Info - ",idStr);

        MediaPlayer mplayer = MediaPlayer.create(this, resourceId);
        mplayer.start();

    }
}

package com.example.alex.mathleague;
package com.example.androidfourthapp;

import android.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.*;
import android.content.Context;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
public class MainActivity extends Activity {

    final Context context = this;
    MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        player = MediaPlayer.create(MainActivity.this, R.raw.song);
        player.setLooping(true);
        player.setVolume(100,100);
        player.start();

        TextView playB = (TextView) this.findViewById(R.id.playButton);
        TextView settingB = (TextView) this.findViewById(R.id.optionsButton);
        TextView helpB = (TextView) this.findViewById(R.id.helpButton);

        playB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Show Game List", Toast.LENGTH_SHORT).show();
                Intent it = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(it);
            }
        });

        settingB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Show Setting List", Toast.LENGTH_SHORT).show();
                Intent it = new Intent(getApplicationContext(), ThirdActivity.class);
                startActivity(it);
            }
        });

        helpB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Show Help List", Toast.LENGTH_SHORT).show();
                Intent it = new Intent(getApplicationContext(), FourthActivity.class);
                startActivity(it);
            }
        });
    }

    @Override
    public void onBackPressed(){
        AlertDialog.Builder messageBackButtonBuilder = new AlertDialog.Builder(context);
        //set title
        messageBackButtonBuilder.setTitle("Exit game");

        //set dialog message
        messageBackButtonBuilder.setMessage("Are you sure you want to exit the Math League?");
        messageBackButtonBuilder.setCancelable(false);
        messageBackButtonBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //if this button is click close current activity
                MainActivity.this.finish();
            }

        });
        messageBackButtonBuilder.setNegativeButton("No", new DialogInterface.OnClickListener(){
            public void onClick (DialogInterface dialog, int id) {
                //if this button is click close dialog box
                dialog.cancel();
            }

        });
        //creates alert dialog
        AlertDialog alertDialog = messageBackButtonBuilder.create();
        //shows it
        alertDialog.show();

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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_HOME)) {
            Toast.makeText(this, "You pressed the home button!", Toast.LENGTH_LONG).show();
            player.pause();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
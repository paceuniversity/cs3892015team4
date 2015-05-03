package com.example.alex.mathleague;

import android.app.ActionBar;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
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

import java.util.List;


public class MainActivity extends Activity {

    final Context context = this;
    static MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        player = MediaPlayer.create(MainActivity.this, R.raw.song);
        player.setLooping(true);
        player.setVolume(100, 100);
        player.start();


        TextView playB = (TextView) this.findViewById(R.id.playButton);
        TextView settingB = (TextView) this.findViewById(R.id.optionsButton);
        TextView helpB = (TextView) this.findViewById(R.id.helpButton);

        playB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(it);
            }
        });

        settingB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), ThirdActivity.class);
                startActivity(it);
            }
        });

        helpB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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


    static int length = 0;

    @Override
    protected void onUserLeaveHint(){
        super.onUserLeaveHint();
        player.pause();
        length = player.getCurrentPosition();
    }

    @Override
    protected void onResume(){
        super.onResume();
        if(!MainActivity.player.isPlaying()) {
            player.seekTo(length);
            player.start();
        }
    }


}

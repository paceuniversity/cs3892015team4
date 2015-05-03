package com.example.alex.mathleague;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class SecondActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

        ImageButton additionB = (ImageButton) this.findViewById(R.id.additionButton);
        ImageButton subtractionB = (ImageButton) this.findViewById(R.id.subtractionButton);
        ImageButton shapesB = (ImageButton) this.findViewById(R.id.shapesButton);

        additionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), AdditionGame.class);
                startActivity(it);
            }
        });

        subtractionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), SubtractionGame.class);
                startActivity(it);
            }
        });

        shapesB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), ShapesGame.class);
                startActivity(it);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
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


    //Copy from here down to every activity so that the music pauses and resumes when you close and reopen
    //the app
    static int length = 0;

    @Override
    protected void onUserLeaveHint(){
        super.onUserLeaveHint();
        MainActivity.player.pause();
        length = MainActivity.player.getCurrentPosition();
    }

    @Override
    protected void onResume(){
        super.onResume();
        if(!MainActivity.player.isPlaying()) {
            MainActivity.player.seekTo(length);
            MainActivity.player.start();
        }
    }



}

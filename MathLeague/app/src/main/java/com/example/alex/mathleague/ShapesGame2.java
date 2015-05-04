package com.example.alex.mathleague;

/**
 * Created by Hanna on 4/20/15.
 */

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class ShapesGame2 extends Activity {

    public static int timesIncorrect = 0, hintCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shapes_game2);

        TextView hint = (TextView) this.findViewById(R.id.HintButton3);
        ImageButton imageButton5 = (ImageButton) this.findViewById(R.id.imageButton5);
        ImageButton imageButton6 = (ImageButton) this.findViewById(R.id.imageButton6);
        ImageButton imageButton7 = (ImageButton) this.findViewById(R.id.imageButton7);
        ImageButton imageButton8 = (ImageButton) this.findViewById(R.id.imageButton8);

        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hintCount++;
                if(hintCount % 2 != 0)
                    Toast.makeText(getApplicationContext(), "An octogon has 8 sides", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Count the number of sides", Toast.LENGTH_SHORT).show();
            }
        });

        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                timesIncorrect++;
            }
        });

        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                Intent it = new Intent(getApplicationContext(), ShapesResults.class);
                startActivity(it);
            }
        });

        imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                timesIncorrect++;
            }
        });

        imageButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                timesIncorrect++;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_shapes_game2, menu);
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

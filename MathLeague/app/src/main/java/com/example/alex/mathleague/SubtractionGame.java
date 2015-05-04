package com.example.alex.mathleague;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;




public class SubtractionGame extends Activity {

    public TextView ans1B, ans2B, ans3B, ans4B, hint;
    public static int hintCount = 0, timesIncorrect = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_subtraction_game);

        hint = (TextView) this.findViewById(R.id.hintButtonS);
        ans1B = (TextView) this.findViewById(R.id.ans1);
        ans2B = (TextView) this.findViewById(R.id.ans2);
        ans3B = (TextView) this.findViewById(R.id.ans3);
        ans4B = (TextView) this.findViewById(R.id.ans4);

        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hintCount++;
                if (hintCount % 2 != 0)
                    Toast.makeText(getApplicationContext(), "Subtract the mask with the X", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Count the masks without the X", Toast.LENGTH_SHORT).show();
            }
        });


        ans1B.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
                      Intent it = new Intent(getApplicationContext(), SubtractionGame2.class);
                      startActivity(it);
            }
        });

        ans2B.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Sorry, try again", Toast.LENGTH_SHORT).show();
                timesIncorrect++;
            }
        });

        ans3B.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Sorry, try again", Toast.LENGTH_SHORT).show();
                timesIncorrect++;
            }
        });

        ans4B.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Sorry, try again", Toast.LENGTH_SHORT).show();
                timesIncorrect++;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_subtraction_game, menu);
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

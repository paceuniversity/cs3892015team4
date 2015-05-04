package com.example.alex.mathleague;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class AdditionGame extends Activity {

   public static int timesIncorrect = 0, hintCount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_addition_game);

        TextView hint = (TextView) this.findViewById(R.id.hintbutton);

        TextView ans1 = (TextView) this.findViewById(R.id.ans1);
        TextView ans2 = (TextView) this.findViewById(R.id.ans2);
        TextView ans3 = (TextView) this.findViewById(R.id.ans3);

        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hintCount++;
                if(hintCount % 2 != 0)
                    Toast.makeText(getApplicationContext(), "Count the number of DOGS", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Ignore the CATS", Toast.LENGTH_SHORT).show();
            }
        });

        ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                timesIncorrect++;
            }
        });

        ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                timesIncorrect++;
            }
        });

        ans3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                Intent it = new Intent(getApplicationContext(), AdditionGame2.class);
                startActivity(it);
            }
        });
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

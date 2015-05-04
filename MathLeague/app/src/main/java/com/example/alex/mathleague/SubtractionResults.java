package com.example.alex.mathleague;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SubtractionResults extends Activity{
    int totalIncorrect = 0, totalAttempts = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subtraction_results);

        totalIncorrect = SubtractionGame.timesIncorrect + SubtractionGame2.timesIncorrect;
        totalAttempts = totalIncorrect + 2;

        TextView incorrect = (TextView) this.findViewById(R.id.textView3);
        TextView attempts = (TextView) this.findViewById(R.id.textView4);
        TextView bubble = (TextView) this.findViewById(R.id.textView5);

        Button backButton = (Button) this.findViewById(R.id.button);

        if(totalIncorrect == 0)
            bubble.setText("PERFECT!");
        else if((totalIncorrect / totalAttempts) > .5 )
            bubble.setText("Good Job");

        attempts.setText("Number of tries: " + totalAttempts);
        incorrect.setText("Number of times wrong: " + totalIncorrect);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SubtractionGame.timesIncorrect = 0;
                SubtractionGame2.timesIncorrect = 0;
                Intent it = new Intent(getApplicationContext(), MainActivity.class);
                MainActivity.player.stop();
                startActivity(it);
            }
        });


        SubtractionGame.timesIncorrect = 0;
        SubtractionGame2.timesIncorrect = 0;
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

package com.example.alex.mathleague;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class AdditionResults extends Activity {

    int totalIncorrect = 0, totalAttempts = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition_results);

        totalIncorrect = AdditionGame.timesIncorrect + AdditionGame2.timesIncorrect;
        totalAttempts = totalIncorrect + 2;

        AdditionGame.timesIncorrect = 0;
        AdditionGame2.timesIncorrect = 0;



    }
}

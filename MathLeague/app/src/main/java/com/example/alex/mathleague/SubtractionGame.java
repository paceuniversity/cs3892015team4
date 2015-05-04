package com.example.alex.mathleague;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Toast;
import android.widget.*;


public class SubtractionGame extends Activity {

    public TextView ans1B, ans2B, ans3B, ans4B;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_subtraction_game);

        ans1B = (TextView) this.findViewById(R.id.ans1);
        ans2B = (TextView) this.findViewById(R.id.ans2);
      //  ans3B = (TextView) this.findViewById(R.id.ans3);
        ans4B = (TextView) this.findViewById(R.id.ans4);



        ans1B.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
         //       Intent it = new Intent(getApplicationContext(), ThirdActivity.class);
         //       startActivity(it);
            }
        });

        ans2B.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Sorry, try again", Toast.LENGTH_SHORT).show();
            }
        });

    //    ans3B.setOnClickListener(new OnClickListener(){

     //       @Override
     //       public void onClick(View v) {
     //           Toast.makeText(getApplicationContext(), "Sorry, try again", Toast.LENGTH_SHORT).show();
     //       }
     //   });

        ans4B.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Sorry, try again", Toast.LENGTH_SHORT).show();
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
}

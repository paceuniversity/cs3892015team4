package com.example.alex.mathleague;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class SecondActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ImageView additionB = (ImageView) this.findViewById(R.id.additionButton);
        ImageView subtractionB = (ImageView) this.findViewById(R.id.subtractionButton);
        ImageView shapesB = (ImageView) this.findViewById(R.id.shapesButton);

        additionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Show Addition Game", Toast.LENGTH_SHORT).show();
                Intent it = new Intent(getApplicationContext(), AdditionGame.class);
                startActivity(it);
            }
        });

        subtractionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Show Substraction Game", Toast.LENGTH_SHORT).show();
                Intent it = new Intent(getApplicationContext(), SubtractionGame.class);
                startActivity(it);
            }
        });

        shapesB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Show Shapes Game", Toast.LENGTH_SHORT).show();
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
}

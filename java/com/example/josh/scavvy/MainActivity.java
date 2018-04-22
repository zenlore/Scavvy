package com.example.josh.scavvy;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ScavHunt> scavHunts = new ArrayList<ScavHunt>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        makeSampleData();
        LinearLayout yourlayout= (LinearLayout) findViewById(R.id.huntListLayout);

        for (int i = 0; i < scavHunts.size(); i++) {
            Button btn = new Button (MainActivity.this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);
            btn.setLayoutParams(params);
            btn.setTextSize(32);
            btn.setText(scavHunts.get(i).getName());
            yourlayout.addView(btn);
        }
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

    public void makeSampleData(){
        //Make mammals scavhunt
        ArrayList<ScavItem> scavItems = new ArrayList<ScavItem>();
        scavItems.add(new ScavItem("Cat"));
        scavItems.add(new ScavItem("Dog"));
        scavItems.add(new ScavItem("Human"));
        scavItems.add(new ScavItem("Squirrel"));
        scavItems.add(new ScavItem("Cow"));
        scavItems.add(new ScavItem("Sheep"));
        ScavHunt bigAnimals = new ScavHunt("Mammals", scavItems, 0);
        this.scavHunts.add(bigAnimals);
        scavItems.clear();
        scavItems.add(new ScavItem("Doritos"));
        scavItems.add(new ScavItem("Mountain Dew"));
        scavItems.add(new ScavItem("Cheeto Dust"));
        scavItems.add(new ScavItem("Waifu"));
        ScavHunt neckbeard_shit = new ScavHunt("Neckbeard Shit", scavItems, 0);
        this.scavHunts.add(neckbeard_shit);
    }
}
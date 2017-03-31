package com.example.nyambura.myfitness;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by nyambura on 3/18/17.
 */

public class WorkoutActivity extends AppCompatActivity {
    GridView gridView;

    String[] workouts = new String[] {
            "Abs", "Arms", "Butt", "Fullbody"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Gloss_And_Bloom.ttf"); //change



        gridView = (GridView) findViewById(R.id.baseGridView);

        gridView.setAdapter(new WorkoutAdapter(this, workouts, typeface));


    }
}

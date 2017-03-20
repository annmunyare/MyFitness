package com.example.nyambura.myfitness;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by nyambura on 3/18/17.
 */

public class GymActivity extends AppCompatActivity {
    public static final String TAG = GymActivity.class.getSimpleName();

    @Bind(R.id.locationTextView)
    TextView mLocationTextView;
    @Bind(R.id.listView)
    ListView mListView;

    private String[] gyms = new String[] {"HillCourt", "Wadi Degla", "Amber",
            };
    private String[] types = new String[] {"world Class Trainers", "High Quality Facility", "Aerobics"
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gym);
        ButterKnife.bind(this);

        GymArrayAdapter adapter = new GymArrayAdapter(this, android.R.layout.simple_list_item_1, gyms, types);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String restaurant = ((TextView)view).getText().toString();
                Toast.makeText(GymActivity.this, restaurant, Toast.LENGTH_LONG).show();
                Log.v(TAG, "In Gym");
            }
        });

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mLocationTextView.setText("Here are all the Gyms near: " + location);
        Log.d(TAG, "In the onCreate method!");
    }
}

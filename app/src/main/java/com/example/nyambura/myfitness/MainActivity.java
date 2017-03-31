package com.example.nyambura.myfitness;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @Bind(R.id.findGymButton)
    Button mFindGymButton;
    @Bind(R.id.bmiButton)
    Button mBmiButton;
    @Bind(R.id.workoutButton)
    Button mWorkoutButton;
    @Bind(R.id.savedGymsButton) Button mSavedGymsButton;

    @Bind(R.id.locationEditText)
    EditText mLocationEditText;
    @Bind(R.id.appNameTextView)
    TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Typeface robotoItalicFont = Typeface.createFromAsset(getAssets(), "fonts/rob.ttf");
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();
        mAppNameTextView.setTypeface(robotoItalicFont);
        mFindGymButton.setOnClickListener(this);
        mBmiButton.setOnClickListener(this);
        mWorkoutButton.setOnClickListener(this);
        mSavedGymsButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == mFindGymButton) {
            String location = mLocationEditText.getText().toString();
            addToSharedPreferences(location);
            if(!(location).equals("")) {
                addToSharedPreferences(location);
            }
            Intent intent = new Intent(MainActivity.this, GymListActivity.class);
            startActivity(intent);
        }

        if(v==mBmiButton){
            Intent intent = new Intent(MainActivity.this, BmiActivity.class);
            startActivity(intent);
        }
        if(v==mWorkoutButton){
            Intent intent = new Intent(MainActivity.this, WorkoutActivity.class);
            startActivity(intent);
        }
        if (v == mSavedGymsButton) {
            Intent intent = new Intent(MainActivity.this, SavedGymListActivity.class);
            startActivity(intent);
        }

}
    private void addToSharedPreferences(String location) {
        mEditor.putString(Constants.PREFERENCES_LOCATION_KEY, location).apply();
    }}


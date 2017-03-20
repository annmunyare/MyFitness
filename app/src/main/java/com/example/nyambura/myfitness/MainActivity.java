package com.example.nyambura.myfitness;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    @Bind(R.id.findGymButton)Button mGymButton;
    @Bind(R.id.recipeButton)Button mRecipeButton;

    @Bind(R.id.locationEditText) EditText mLocationEditText;
    @Bind(R.id.appNameTextView) TextView mAppNameTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Typeface robotoItalicFont = Typeface.createFromAsset(getAssets(), "fonts/robotoItalic.ttf");
        mAppNameTextView.setTypeface(robotoItalicFont);
        mGymButton.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        if(v == mGymButton) {
            String location = mLocationEditText.getText().toString();
            Intent intent = new Intent(MainActivity.this, GymActivity.class);
            intent.putExtra("location", location);
            startActivity(intent);
        }
        else{
        (v == mRecipeButton) {

            Intent intent = new Intent(MainActivity.this, WorkoutActivity.class);

            startActivity(intent);

    }

}}

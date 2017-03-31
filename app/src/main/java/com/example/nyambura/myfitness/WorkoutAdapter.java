package com.example.nyambura.myfitness;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by nyambura on 3/18/17.
 */

public class WorkoutAdapter extends BaseAdapter {
    public WorkoutAdapter() {
        super();
    }

    @Override
    public int getCount() {
        return mWorkouts.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {
            // get layout from xml file
            gridView = inflater.inflate(R.layout.workout_grid_item, null);


            // pull views
            TextView workoutView = (TextView) gridView
                    .findViewById(R.id.grid_item_workout);

            // set values into views
            workoutView.setText(mWorkouts[position]);
            workoutView.setTypeface(mTypeface);// using dummy data for now
        } else {
            gridView = (View) convertView;
        }
        return gridView;
    }

    private Context mContext;
    private String[] mWorkouts;
    private Typeface mTypeface;

    public WorkoutAdapter (Context context, String[] workouts, Typeface typeface){
        this.mContext = context;
        this.mWorkouts = workouts;
        this.mTypeface = typeface;
    }


}
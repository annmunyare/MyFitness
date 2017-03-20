package com.example.nyambura.myfitness;

import android.content.Context;
import android.widget.ArrayAdapter;

/**
 * Created by nyambura on 3/18/17.
 */

public class GymArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mGyms;
    private String[] mTypes;

    public GymArrayAdapter(Context mContext, int resource, String[] mGyms, String[] mTypes) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mGyms = mGyms;
        this.mTypes = mTypes;

    }
    @Override
    public Object getItem(int position) {
        String gym = mGyms[position];
        String types = mTypes[position];
        return String.format("%s \nHave: %s", gym, types);
    }

    @Override
    public int getCount() {
        return mGyms.length;
    }
}



package com.example.nyambura.myfitness;

/**
 * Created by nyambura on 3/28/17.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class GymPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Gym> mGyms;

    public GymPagerAdapter(FragmentManager fm, ArrayList<Gym> gyms) {
        super(fm);
        mGyms = gyms;
    }

    @Override
    public Fragment getItem(int position) {
        return GymDetailFragment.newInstance(mGyms.get(position));
    }

    @Override
    public int getCount() {
        return mGyms.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mGyms.get(position).getName();
    }
}
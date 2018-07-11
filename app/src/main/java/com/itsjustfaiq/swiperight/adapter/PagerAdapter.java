package com.itsjustfaiq.swiperight.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.itsjustfaiq.swiperight.fragments.Info;
import com.itsjustfaiq.swiperight.fragments.News;
import com.itsjustfaiq.swiperight.fragments.Tutorial;

public class PagerAdapter extends FragmentStatePagerAdapter {
    public PagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new News();
            case 1: return new Tutorial();
            case 2: return new Info();
            default: return new News();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position){
        switch (position){
            case 0: return "News";
            case 1: return "Tutorial";
            default: return "Info";
        }
    }
}

package com.itsjustfaiq.swiperight;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    public PagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (position){
            case 0:
            case 1:
            case 2:
        };
    }

    @Override
    public int getCount() {
        return 3;
    }
}

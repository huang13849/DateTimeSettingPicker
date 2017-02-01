package com.huangfra.picker;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by huangfra on 2017/1/30.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter{

    ArrayList<Fragment> list;
    public MyFragmentPagerAdapter(FragmentManager fm ,ArrayList<Fragment>list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}

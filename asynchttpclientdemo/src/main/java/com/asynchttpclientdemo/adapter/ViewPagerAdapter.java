package com.asynchttpclientdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by guojiadong
 * on 2017/1/5.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;
    private String[] titles = new String[]{"笑不笑", "笑笑笑"};

    public ViewPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragmentList = fragments;
    }


    @Override
    public Fragment getItem(int position) {
        return fragmentList == null || fragmentList.isEmpty() ? null : fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList == null || fragmentList.isEmpty() ? 0 : fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}

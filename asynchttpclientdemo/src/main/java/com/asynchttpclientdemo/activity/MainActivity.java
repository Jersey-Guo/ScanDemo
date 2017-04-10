package com.asynchttpclientdemo.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.asynchttpclientdemo.R;
import com.asynchttpclientdemo.adapter.ViewPagerAdapter;
import com.asynchttpclientdemo.base.BaseActivity;
import com.asynchttpclientdemo.fragments.IconJokeFragment;
import com.asynchttpclientdemo.fragments.NewestJokeFragment;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity {
    private TabLayout mTab;
    private ViewPager mViewP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setModel();

    }

    @Override
    public void initView() {
        mTab = (TabLayout) findViewById(R.id.main_tablayout);
        mViewP = (ViewPager) findViewById(R.id.main_viewpager);
    }

    @Override
    public void setModel() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new NewestJokeFragment());
        fragments.add(new IconJokeFragment());
        ViewPagerAdapter pageAdapter = new ViewPagerAdapter(getSupportFragmentManager(),fragments);
        mViewP.setAdapter(pageAdapter);
        mViewP.setCurrentItem(0);
        mViewP.setOffscreenPageLimit(2);
        mTab.setupWithViewPager(mViewP);
        mTab.setTabMode(TabLayout.MODE_FIXED);
    }

    @Override
    public void getData() {

    }


}

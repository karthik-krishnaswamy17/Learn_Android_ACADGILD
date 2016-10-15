package com.android.developer.learn_android_acadgild;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

import com.android.developer.learn_android_acadgild.Fragments.FragmentAudio;
import com.android.developer.learn_android_acadgild.Fragments.FragmentVideo;

public class MainActivity extends ActionBarActivity implements ActionBar.TabListener {
    ViewPager viewPager;
    ActionBar actionbar;
    private String[] Tabs = {"Audio", "Video"};
    private int[] drawable_id = {android.R.drawable.presence_audio_away, android.R.drawable.presence_video_away};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                actionbar.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        actionbar = getSupportActionBar();
        actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);


        for (int i = 0; i < Tabs.length; i++) {
            ActionBar.Tab tab = actionbar.newTab().setText(Tabs[i]).setIcon(drawable_id[i]);
            tab.setTabListener(this);
            actionbar.addTab(tab);

        }


    }


    @Override
    public void onTabSelected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {


        viewPager.setCurrentItem(tab.getPosition());

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }
}

class PagerAdapter extends FragmentPagerAdapter {

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0)
            fragment = new FragmentAudio();
        if (position == 1)
            fragment = new FragmentVideo();

        return fragment;

    }

    @Override
    public int getCount() {
        return 2;
    }


}
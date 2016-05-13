package com.afollestad.polar.adapters;


import android.app.Fragment;
import android.app.FragmentManager;

import com.afollestad.polar.util.PagesBuilder;
import com.afollestad.polar.viewer.FragmentStatePagerAdapter;
import android.view.View;

/**
 * @author Aidan Follestad (afollestad)
 */
public class MainPagerAdapter extends FragmentStatePagerAdapter {

    private final PagesBuilder mPages;

    public MainPagerAdapter(FragmentManager fm, PagesBuilder pages) {
        super(fm);
        mPages = pages;
    }
    public void onClick(View v) {

    }

    @Override
    protected Fragment getItem(int position) {
        return mPages.get(position).fragment;
    }

    @Override
    public int getCount() {
        return mPages.size();
    }
}
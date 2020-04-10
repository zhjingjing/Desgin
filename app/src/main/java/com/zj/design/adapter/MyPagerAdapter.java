package com.zj.design.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.zj.design.base.BaseFragment;

import java.util.List;

/**
 * create by zj on 2020/4/10
 * viewpager adapter
 */
public class MyPagerAdapter extends FragmentStatePagerAdapter {
    List<BaseFragment> fragments;
    public MyPagerAdapter(FragmentManager fm, List<BaseFragment> fragments) {
        super(fm);
        this.fragments=fragments;
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragments.get(position).getTitle();
    }
}

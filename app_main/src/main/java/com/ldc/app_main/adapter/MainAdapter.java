package com.ldc.app_main.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目: BleApp
 * 包名: com.ldc.app_main.adapter
 * 作者: liudi
 * 创建时间: 2020/10/11
 */
public class MainAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> fragments;

    public MainAdapter(@NonNull FragmentManager fm) {
        super(fm, FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    public void setNewData(List<Fragment> d) {
        if (null == d) return;
        fragments = new ArrayList<>(d);
        notifyDataSetChanged();
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return null == fragments ? 0 : fragments.size();
    }
}

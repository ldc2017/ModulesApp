package com.ldc.app_main.action.activity;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.ldc.app_base.core.BaseVBActivity;
import com.ldc.app_main.R;
import com.ldc.app_main.action.fragment.HomeFragment;
import com.ldc.app_main.action.fragment.MeFragment;
import com.ldc.app_main.action.fragment.MessageFragment;
import com.ldc.app_main.adapter.MainAdapter;
import com.ldc.app_main.databinding.MainActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends BaseVBActivity<MainActivityMainBinding> {

    private final ArrayList<Fragment> fragments = new ArrayList<>();
    private MainAdapter mainAdapter;

    @Override
    protected MainActivityMainBinding initBinding() {
        return MainActivityMainBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initView() {
        super.initView();
        initStatusBar(Color.RED, false);
        initAdapter();
        viewBinding.flHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor(0);
            }
        });
        viewBinding.flMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor(1);
            }
        });
        viewBinding.flMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor(2);
            }
        });
    }

    @Override
    protected void initError(Exception e) {
        super.initError(e);
        Log.e(TAG, String.format("initError: ============%s", e.getLocalizedMessage()));
    }

    private void initAdapter() {
        fragments.add(HomeFragment.Instance("首页", "1"));
        fragments.add(MessageFragment.Instance("消息", "2"));
        fragments.add(MeFragment.Instance("个人中心", "3"));
        if (null == mainAdapter) {
            mainAdapter = new MainAdapter(getSupportFragmentManager());
        }
        mainAdapter.setNewData(fragments);
        viewBinding.vp.setAdapter(mainAdapter);
        changeColor(0);
        viewBinding.vp.setOffscreenPageLimit(3);
        viewBinding.vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                changeColor(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void changeColor(int pos) {
        viewBinding.vp.setCurrentItem(pos);
        switch (pos) {
            case 0:
                viewBinding.ivHome.setImageResource(R.drawable.main_icon_home_pre);
                viewBinding.ivMessage.setImageResource(R.drawable.main_icon_message);
                viewBinding.ivMe.setImageResource(R.drawable.main_icon_personal);
                //
                viewBinding.tvHome.setTextColor(getResources().getColor(R.color.color_d4237a));
                viewBinding.tvMessage.setTextColor(getResources().getColor(R.color.color_8a8a8a));
                viewBinding.tvMe.setTextColor(getResources().getColor(R.color.color_8a8a8a));
                break;
            case 1:

                viewBinding.ivHome.setImageResource(R.drawable.main_icon_home);
                viewBinding.ivMessage.setImageResource(R.drawable.main_icon_message_pre);
                viewBinding.ivMe.setImageResource(R.drawable.main_icon_personal);
                //
                viewBinding.tvHome.setTextColor(getResources().getColor(R.color.color_8a8a8a));
                viewBinding.tvMessage.setTextColor(getResources().getColor(R.color.color_d4237a));
                viewBinding.tvMe.setTextColor(getResources().getColor(R.color.color_8a8a8a));
                break;
            case 2:
                viewBinding.ivHome.setImageResource(R.drawable.main_icon_home);
                viewBinding.ivMessage.setImageResource(R.drawable.main_icon_message);
                viewBinding.ivMe.setImageResource(R.drawable.main_icon_personal_pre);
                //
                viewBinding.tvHome.setTextColor(getResources().getColor(R.color.color_8a8a8a));
                viewBinding.tvMessage.setTextColor(getResources().getColor(R.color.color_8a8a8a));
                viewBinding.tvMe.setTextColor(getResources().getColor(R.color.color_d4237a));
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (null != fragments) {
            for (Fragment fragment : fragments) {
                fragment.onActivityResult(requestCode, resultCode, data);
            }
        }
    }
}
package com.ldc.app_main.action.fragment;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProvider;

import com.ldc.app_base.core.BaseVMFragment;
import com.ldc.app_bluetooth.action.AppBlueToothMainActivity;
import com.ldc.app_main.action.vm.HomeVM;
import com.ldc.app_main.databinding.FragmentHomeBinding;
import com.ldc.app_wifi.AppWifiActivity;


public class HomeFragment extends BaseVMFragment<HomeVM, FragmentHomeBinding> {
    private static final String PARAMS1 = "";
    private static final String PARAMS2 = "";

    public static HomeFragment Instance(String p1, String p2) {
        HomeFragment homeFragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putString(PARAMS1, p1);
        bundle.putString(PARAMS2, p2);
        homeFragment.setArguments(bundle);
        return homeFragment;
    }


    @Override
    protected HomeVM initViewModel() {
        return ViewModelProvider.AndroidViewModelFactory
                .getInstance(getActivity().getApplication()).create(HomeVM.class);
    }


    @Override
    protected FragmentHomeBinding initBinding() {
        return FragmentHomeBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initView() {
        super.initView();
        viewBinding.btnClick.setOnClickListener(v -> {
            AppBlueToothMainActivity.start(getContext());
        });
        viewBinding.btnClick2.setOnClickListener(v -> {
            AppWifiActivity.start(getContext());
        });
    }
}
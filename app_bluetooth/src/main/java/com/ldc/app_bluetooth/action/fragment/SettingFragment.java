package com.ldc.app_bluetooth.action.fragment;

import android.os.Bundle;

import com.ldc.app_base.core.BaseVMFragment;
import com.ldc.app_bluetooth.databinding.BleFragmentSettingBinding;
import com.ldc.app_bluetooth.vm.SettingVM;


public class SettingFragment extends BaseVMFragment<SettingVM, BleFragmentSettingBinding> {
    public static SettingFragment newInstance() {
        Bundle args = new Bundle();
        SettingFragment fragment = new SettingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected SettingVM initViewModel() {
        return createViewModel(getActivity().getApplication(), SettingVM.class);
    }

    @Override
    protected BleFragmentSettingBinding initBinding() {
        return BleFragmentSettingBinding.inflate(getLayoutInflater());
    }
}
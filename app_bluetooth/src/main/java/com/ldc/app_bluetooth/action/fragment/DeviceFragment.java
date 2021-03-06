package com.ldc.app_bluetooth.action.fragment;

import android.os.Bundle;

import com.ldc.app_base.core.BaseVMFragment;
import com.ldc.app_bluetooth.databinding.BleFragmentDeviceBinding;
import com.ldc.app_bluetooth.vm.DeviceVM;


public class DeviceFragment extends BaseVMFragment<DeviceVM, BleFragmentDeviceBinding> {
    public static DeviceFragment newInstance() {
        Bundle args = new Bundle();
        DeviceFragment fragment = new DeviceFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected DeviceVM initViewModel() {
        return createViewModel(getActivity().getApplication(), DeviceVM.class);
    }

    @Override
    protected BleFragmentDeviceBinding initBinding() {
        return BleFragmentDeviceBinding.inflate(getLayoutInflater());
    }
}
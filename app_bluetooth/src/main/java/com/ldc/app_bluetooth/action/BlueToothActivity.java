package com.ldc.app_bluetooth.action;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ldc.app_base.core.BaseVBActivity;
import com.ldc.app_bluetooth.MyUrl;
import com.ldc.app_bluetooth.databinding.ActivityBlueToothBinding;

@Route(path = MyUrl.BlueToothActivity)
public class BlueToothActivity extends BaseVBActivity<ActivityBlueToothBinding> {


    @Override
    protected ActivityBlueToothBinding initBinding() {
        return ActivityBlueToothBinding.inflate(getLayoutInflater());
    }
}
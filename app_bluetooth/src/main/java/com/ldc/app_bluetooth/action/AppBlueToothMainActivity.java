package com.ldc.app_bluetooth.action;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

import com.ldc.app_base.core.BaseVBActivity;
import com.ldc.app_bluetooth.databinding.ActivityAppBlueToothBinding;


public class AppBlueToothMainActivity extends BaseVBActivity<ActivityAppBlueToothBinding> {


    public static void start(Context context) {
        final ComponentName componentName = new ComponentName(context, AppBlueToothMainActivity.class);
        Intent intent = new Intent();
        intent.setComponent(componentName);
        context.startActivity(intent);

    }


    @Override
    protected ActivityAppBlueToothBinding initBinding() {
        return ActivityAppBlueToothBinding.inflate(getLayoutInflater());
    }
}
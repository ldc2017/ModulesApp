package com.ldc.app_bluetooth.action;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

import com.ldc.app_base.core.BaseVBActivity;
import com.ldc.app_bluetooth.databinding.ActivityBlueToothBinding;


public class BlueToothActivity extends BaseVBActivity<ActivityBlueToothBinding> {


    public static void start(Context context) {
        final ComponentName componentName = new ComponentName(context, BlueToothActivity.class);
        Intent intent = new Intent();
        intent.setComponent(componentName);
        context.startActivity(intent);

    }


    @Override
    protected ActivityBlueToothBinding initBinding() {
        return ActivityBlueToothBinding.inflate(getLayoutInflater());
    }
}
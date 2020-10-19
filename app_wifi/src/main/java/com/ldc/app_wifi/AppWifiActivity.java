package com.ldc.app_wifi;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class AppWifiActivity extends AppCompatActivity {
    public static void start(Context context) {
        final ComponentName componentName = new ComponentName(context, AppWifiActivity.class);
        Intent intent = new Intent();
        intent.setComponent(componentName);
        context.startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wifi_activity_wifi);
    }
}
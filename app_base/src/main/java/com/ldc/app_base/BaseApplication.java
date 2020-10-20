package com.ldc.app_base;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;

import androidx.multidex.MultiDex;

/**
 * 项目: BleApp
 * 包名: com.ldc.app_base
 * 作者: liudi
 * 创建时间: 2020/10/10
 */
public  class BaseApplication extends Application {

    public static boolean isMainProcess() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.err.println(String.format("app ========= %s", getClass().getName()));
        if (isMainProcess()) {
            ThirdSDKService.start(this, new Intent());
        }
    }


}

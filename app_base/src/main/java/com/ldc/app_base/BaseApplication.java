package com.ldc.app_base;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;

import androidx.multidex.MultiDex;

import com.ldc.app_base.config.ModuleAppInit;
import com.ldc.app_base.init.BaseAppInit;

/**
 * 项目: BleApp
 * 包名: com.ldc.app_base
 * 作者: liudi
 * 创建时间: 2020/10/10
 */
public abstract class BaseApplication extends Application {
    private static BaseApplication application;

    public static BaseApplication getApplication() {
        return application;
    }

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
        application = this;
        if (isMainProcess()) {
            ThirdSDKService.start(this, new Intent());
        }
    }

    //高优先级
    protected void moduleAppInit() {
        try {
            for (String init : ModuleAppInit.modulesInit) {
                Class<?> clazz = Class.forName(init);
                BaseAppInit baseAppInit = (BaseAppInit) clazz.newInstance();
                baseAppInit.init(this);
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.err.println(String.format("%s", e.getLocalizedMessage()));
        }
    }
}

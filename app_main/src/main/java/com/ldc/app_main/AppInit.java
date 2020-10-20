package com.ldc.app_main;

import android.app.Application;

import com.ldc.app_base.CommonApplication;

/**
 * 项目: BleApp
 * 包名: com.ldc.app_main
 * 作者: liudi
 * 创建时间: 2020/10/10
 */
public class AppInit extends CommonApplication {
    private static Application application;

    public static Application getApplication() {
        return application;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    @Override
    protected void init(Application app) {
        application =  app;
    }
}

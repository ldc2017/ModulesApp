package com.ldc.app_bluetooth;

import android.app.Application;

import com.ldc.app_base.CommonApplication;

/**
 * 项目: ModulesApp
 * 包名: com.ldc.app_bluetooth
 * 作者: liudi
 * 创建时间: 2020/10/17
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
        application = app;

    }


}

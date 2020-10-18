package com.ldc.app_bluetooth;

import android.app.Application;

import com.ldc.app_base.init.BaseAppInit;

/**
 * 项目: ModulesApp
 * 包名: com.ldc.app_bluetooth
 * 作者: liudi
 * 创建时间: 2020/10/17
 */
public class AppInit implements BaseAppInit {
    private static Application application;

    public static Application getApplication() {
        return application;
    }

    /**
     * @param app
     * @return
     */
    @Override
    public boolean init(Application app) {
        application = app;
        return true;
    }
}
